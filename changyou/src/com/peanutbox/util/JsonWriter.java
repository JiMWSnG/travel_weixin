/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.peanutbox.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.CharacterIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * <p>
 * Serializes an object into JavaScript Object Notation (JSON). If cyclic
 * references are detected they will be nulled out.
 * </p>
 * liangpeng.
 */
public class JsonWriter {

	private static final Logger LOG = LoggerFactory.getLogger(JsonWriter.class);

	/**
	 * By default, enums are serialised as name=value pairs
	 */
	public static final boolean ENUM_AS_BEAN_DEFAULT = false;

	private static char[] hex = "0123456789ABCDEF".toCharArray();

	private static final ConcurrentMap<Class<?>, BeanInfo> BEAN_INFO_CACHE_IGNORE_HIERARCHY = new ConcurrentHashMap<Class<?>, BeanInfo>();
	private static final ConcurrentMap<Class<?>, BeanInfo> BEAN_INFO_CACHE = new ConcurrentHashMap<Class<?>, BeanInfo>();

	private StringBuilder buf = new StringBuilder();
	private Stack<Object> stack = new Stack<Object>();
	private boolean ignoreHierarchy = true;
	private Object root;
	private boolean buildExpr = true;
	private String exprStack = "";
	private Collection<Pattern> excludeProperties;
	private Collection<Pattern> includeProperties;
	private DateFormat formatter;
	private boolean enumAsBean = ENUM_AS_BEAN_DEFAULT;
	private boolean excludeNullProperties;
	private int maxDepth;
	private Stack currPath = new Stack();// 保存当前转换对象路径，用来判断当前深度
	private Stack arrayLevel = new Stack();// 保存数组的层级，只转换一级数组，一级以上的数据不再转换
	private boolean containsCollection = true;//是否转换集合
	public JsonWriter() {
		this(3);
	}
	public JsonWriter(int maxDepth,String dateStr) {// 默认3级Object(Map)(1-4)
		this.maxDepth = maxDepth;
		if (maxDepth < 1)
			this.maxDepth = 1;
		else if (maxDepth > 5)
			this.maxDepth = 5;
		if(dateStr != null && dateStr.length() > 0)this.formatter = new SimpleDateFormat(dateStr);
	}
	public JsonWriter(int maxDepth,String dateStr,boolean containsCollection) {// 默认3级Object(Map)(1-4)
		this.maxDepth = maxDepth;
		if (maxDepth < 1)
			this.maxDepth = 1;
		else if (maxDepth > 5)
			this.maxDepth = 5;
		if(dateStr != null && dateStr.length() > 0)this.formatter = new SimpleDateFormat(dateStr);
		this.containsCollection = containsCollection;
	}
	public JsonWriter(int maxDepth) {// 默认3级Object(Map)(1-4)
		this.maxDepth = maxDepth;
		if (maxDepth < 1)
			this.maxDepth = 1;
		else if (maxDepth > 5)
			this.maxDepth = 5;
	}

	/**
	 * @param object
	 *            Object to be serialized into JSON
	 * @return JSON string for object
	 * @throws Exception
	 */
	public String write(Object object) throws Exception {
		return this.write(object, null, null, false);
	}

	/**
	 * @param object
	 *            Object to be serialized into JSON
	 * @return JSON string for object
	 * @throws Exception
	 */
	public String write(Object object, Collection<Pattern> excludeProperties,
			Collection<Pattern> includeProperties, boolean excludeNullProperties)
			throws Exception {
		this.excludeNullProperties = excludeNullProperties;
		this.buf.setLength(0);
		this.root = object;
		this.exprStack = "";
		this.buildExpr = ((excludeProperties != null) && !excludeProperties
				.isEmpty())
				|| ((includeProperties != null) && !includeProperties.isEmpty());
		this.excludeProperties = excludeProperties;
		this.includeProperties = includeProperties;
		this.value(object, null);

		return this.buf.toString();
	}

	/**
	 * Detect cyclic references
	 */
	protected void value(Object object, Method method) throws Exception {
		if (object == null) {
			this.add("null");

			return;
		}

		if (this.stack.contains(object)) {
			Class clazz = object.getClass();

			// cyclic reference
			if (clazz.isPrimitive() || clazz.equals(String.class)) {
				this.process(object, method);
			} else {
				if (LOG.isDebugEnabled()) {
					LOG.debug("Cyclic reference detected on " + object);
				}

				this.add("null");
			}

			return;
		}

		this.process(object, method);
	}

	/**
	 * Serialize object into json
	 */
	protected void process(Object object, Method method) throws Exception {

		this.stack.push(object);
		try {
			if (object instanceof Class) {
				this.string(object);
			} else if (object instanceof Boolean) {
				this.bool((Boolean) object);
			} else if (object instanceof Number) {
				this.add(object);
			} else if (object instanceof String) {
				this.string(object);
			} else if (object instanceof Character) {
				this.string(object);
			} else if (object instanceof Map) {
				currPath.push(object);
				try {// liangpeng.
					this.map((Map) object, method);
				} finally {
					currPath.pop();
				}
			} else if (object.getClass().isArray()) {
				this.array(object, method);
			} else if (object instanceof Iterable) {
				this.array(((Iterable) object).iterator(), method);
			} else if (object instanceof Date) {
				this.date((Date) object, method);
			} else if (object instanceof Calendar) {
				this.date(((Calendar) object).getTime(), method);
			} else if (object instanceof Locale) {
				this.string(object);
			} else if (object instanceof Enum) {
				this.enumeration((Enum) object);
			} else {
				currPath.push(object);
				try {// liangpeng.
					processCustom(object, method);
				} finally {
					currPath.pop();
				}
			}
		} finally {
			this.stack.pop();
		}
	}

	/**
	 * Serialize custom object into json
	 */
	protected void processCustom(Object object, Method method) throws Exception {
		this.bean(object);
	}

	/**
	 * Instrospect bean and serialize its properties
	 */
	protected void bean(Object object) throws Exception {

		this.add("{");

		BeanInfo info;

		try {
			Class clazz = object.getClass();

			info = ((object == this.root) && this.ignoreHierarchy) ? getBeanInfoIgnoreHierarchy(clazz)
					: getBeanInfo(clazz);

			PropertyDescriptor[] props = info.getPropertyDescriptors();

			boolean hasData = false;
			for (PropertyDescriptor prop : props) {
				String name = prop.getName();
				Method accessor = prop.getReadMethod();
				Method baseAccessor = findBaseAccessor(clazz, accessor);

				if (baseAccessor != null) {
					// ignore "class" and others
					if (this.shouldExcludeProperty(prop)) {
						continue;
					}
					String expr = null;
					if (this.buildExpr) {
						expr = this.expandExpr(name);
						if (this.shouldExcludeProperty(expr)) {
							continue;
						}
						expr = this.setExprStack(expr);
					}

					Object value = accessor.invoke(object);
					boolean propertyPrinted = this.add(name, value, accessor,
							hasData);
					hasData = hasData || propertyPrinted;
					if (this.buildExpr) {
						this.setExprStack(expr);
					}
				}
			}

			// special-case handling for an Enumeration - include the name() as
			// a property */
			if (object instanceof Enum) {
				Object value = ((Enum) object).name();
				this.add("_name", value, object.getClass().getMethod("name"),
						hasData);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}

		this.add("}");
	}

	protected BeanInfo getBeanInfoIgnoreHierarchy(final Class<?> clazz)
			throws IntrospectionException {
		BeanInfo beanInfo = BEAN_INFO_CACHE_IGNORE_HIERARCHY.get(clazz);
		if (beanInfo != null) {
			return beanInfo;
		}
		beanInfo = Introspector.getBeanInfo(clazz, clazz.getSuperclass());
		BEAN_INFO_CACHE_IGNORE_HIERARCHY.put(clazz, beanInfo);
		return beanInfo;
	}

	protected BeanInfo getBeanInfo(final Class<?> clazz)
			throws IntrospectionException {
		BeanInfo beanInfo = BEAN_INFO_CACHE.get(clazz);
		if (beanInfo != null) {
			return beanInfo;
		}
		beanInfo = Introspector.getBeanInfo(clazz);
		BEAN_INFO_CACHE.put(clazz, beanInfo);
		return beanInfo;
	}

	protected Method findBaseAccessor(Class clazz, Method accessor) {
		Method baseAccessor = null;
		if (clazz.getName().contains("$$EnhancerByCGLIB$$")) {
			try {
				baseAccessor = Thread.currentThread().getContextClassLoader()
						.loadClass(
								clazz.getName().substring(0,
										clazz.getName().indexOf("$$")))
						.getMethod(accessor.getName(),
								accessor.getParameterTypes());
			} catch (Exception ex) {
				LOG.debug(ex.getMessage(), ex);
			}
		} else if (clazz.getName().contains("$$_javassist")) {
			try {
				baseAccessor = Class.forName(
						clazz.getName().substring(0,
								clazz.getName().indexOf("_$$"))).getMethod(
						accessor.getName(), accessor.getParameterTypes());
			} catch (Exception ex) {
				LOG.debug(ex.getMessage(), ex);
			}
		} else {
			return accessor;
		}
		return baseAccessor;
	}

	/**
	 * Instrospect an Enum and serialize it as a name/value pair or as a bean
	 * including all its own properties
	 */
	protected void enumeration(Enum enumeration) throws Exception {
		if (enumAsBean) {
			this.bean(enumeration);
		} else {
			this.string(enumeration.name());
		}
	}

	protected boolean shouldExcludeProperty(PropertyDescriptor prop)
			throws SecurityException, NoSuchFieldException {
		String name = prop.getName();
		return name.equals("class") || name.equals("declaringClass")
				|| name.equals("cachedSuperClass") || name.equals("metaClass");
	}

	protected String expandExpr(int i) {
		return this.exprStack + "[" + i + "]";
	}

	protected String expandExpr(String property) {
		if (this.exprStack.length() == 0) {
			return property;
		}
		return this.exprStack + "." + property;
	}

	protected String setExprStack(String expr) {
		String s = this.exprStack;
		this.exprStack = expr;
		return s;
	}

	protected boolean shouldExcludeProperty(String expr) {
		if (this.excludeProperties != null) {
			for (Pattern pattern : this.excludeProperties) {
				if (pattern.matcher(expr).matches()) {
					if (LOG.isDebugEnabled()) {
						LOG.debug("Ignoring property because of exclude rule: "
								+ expr);
					}
					return true;
				}
			}
		}

		if (this.includeProperties != null) {
			for (Pattern pattern : this.includeProperties) {
				if (pattern.matcher(expr).matches()) {
					return false;
				}
			}
			if (LOG.isDebugEnabled()) {
				LOG
						.debug("Ignoring property because of include rule:  "
								+ expr);
			}
			return true;
		}
		return false;
	}

	/**
	 * Add name/value pair to buffer
	 */
	protected boolean add(String name, Object value, Method method,
			boolean hasData) throws Exception {
		if (currPath.size() > maxDepth)
			return false;// liangpeng.
		if (excludeNullProperties && value == null) {
			return false;
		}
		if (hasData) {
			this.add(',');
		}
		this.add('"');
		this.add(name);
		this.add("\":");
		this.value(value, method);
		return true;
	}

	/**
	 * Add map to buffer
	 */
	protected void map(Map map, Method method) throws Exception {
		this.add("{");

		Iterator it = map.entrySet().iterator();

		boolean warnedNonString = false; // one report per map
		boolean hasData = false;
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if (excludeNullProperties && entry.getValue() == null) {
				continue;
			}

			Object key = entry.getKey();
			if (key == null) {
				LOG.error("Cannot build expression for null key in #0",
						exprStack);
				continue;
			}

			String expr = null;
			if (this.buildExpr) {
				expr = this.expandExpr(key.toString());
				if (this.shouldExcludeProperty(expr)) {
					continue;
				}
				expr = this.setExprStack(expr);
			}
			if (hasData) {
				this.add(',');
			}
			hasData = true;
			if (!warnedNonString && !(key instanceof String)) {
				if (LOG.isWarnEnabled()) {
					LOG
							.warn(
									"JavaScript doesn't support non-String keys, using toString() on #0",
									key.getClass().getName());
				}
				warnedNonString = true;
			}
			this.value(key.toString(), method);
			this.add(":");
			this.value(entry.getValue(), method);
			if (this.buildExpr) {
				this.setExprStack(expr);
			}
		}

		this.add("}");
	}

	/**
	 * Add date to buffer
	 */
	protected void date(Date date, Method method) {
		if (this.formatter == null)
			this.formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		this.string(formatter.format(date));
	}

	/**
	 * Add array to buffer
	 */
	protected void array(Iterator it, Method method) throws Exception {
		arrayLevel.push(new byte[0]);// liangpeng.
		this.add("[");
		try{
		if ( containsCollection && currPath.size() < maxDepth && arrayLevel.size() <= 1) {// liangpeng.
			boolean hasData = false;
			for (int i = 0; it.hasNext(); i++) {
				String expr = null;
				if (this.buildExpr) {
					expr = this.expandExpr(i);
					if (this.shouldExcludeProperty(expr)) {
						it.next();
						continue;
					}
					expr = this.setExprStack(expr);
				}
				if (hasData) {
					this.add(',');
				}
				hasData = true;
				this.value(it.next(), method);
				if (this.buildExpr) {
					this.setExprStack(expr);
				}
			}
		}// liangpeng.
		}finally{
			arrayLevel.pop();
		}
		this.add("]");
	}

	/**
	 * Add array to buffer
	 */
	protected void array(Object object, Method method) throws Exception {

		arrayLevel.push(new byte[0]);// liangpeng.
		try {
			this.add("[");
			if ( containsCollection && currPath.size() < maxDepth &&  arrayLevel.size() <= 1) {// liangpeng.
				// 判断当前数组层级，如果大于1则不再转换，避免出现过多无用数据
				int length = Array.getLength(object);

				boolean hasData = false;
				for (int i = 0; i < length; ++i) {
					String expr = null;
					if (this.buildExpr) {
						expr = this.expandExpr(i);
						if (this.shouldExcludeProperty(expr)) {
							continue;
						}
						expr = this.setExprStack(expr);
					}
					if (hasData) {
						this.add(',');
					}
					hasData = true;
					this.value(Array.get(object, i), method);
					if (this.buildExpr) {
						this.setExprStack(expr);
					}
				}
			}
			this.add("]");
		} finally {
			arrayLevel.pop();
		}
	}

	/**
	 * Add boolean to buffer
	 */
	protected void bool(boolean b) {
		this.add(b ? "true" : "false");
	}

	/**
	 * escape characters
	 */
	protected void string(Object obj) {
		this.add('"');

		CharacterIterator it = new StringCharacterIterator(obj.toString());

		for (char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
			if (c == '"') {
				this.add("\\\"");
			} else if (c == '\\') {
				this.add("\\\\");
			} else if (c == '/') {
				this.add("\\/");
			} else if (c == '\b') {
				this.add("\\b");
			} else if (c == '\f') {
				this.add("\\f");
			} else if (c == '\n') {
				this.add("\\n");
			} else if (c == '\r') {
				this.add("\\r");
			} else if (c == '\t') {
				this.add("\\t");
			} else if (Character.isISOControl(c)) {
				this.unicode(c);
			} else {
				this.add(c);
			}
		}

		this.add('"');
	}

	/**
	 * Add object to buffer
	 */
	protected void add(Object obj) {
		this.buf.append(obj);
	}

	/**
	 * Add char to buffer
	 */
	protected void add(char c) {
		this.buf.append(c);
	}

	/**
	 * Represent as unicode
	 * 
	 * @param c
	 *            character to be encoded
	 */
	protected void unicode(char c) {
		this.add("\\u");

		int n = c;

		for (int i = 0; i < 4; ++i) {
			int digit = (n & 0xf000) >> 12;

			this.add(hex[digit]);
			n <<= 4;
		}
	}

	public void setIgnoreHierarchy(boolean ignoreHierarchy) {
		this.ignoreHierarchy = ignoreHierarchy;
	}

	/**
	 * If true, an Enum is serialized as a bean with a special property
	 * _name=name() as all as all other properties defined within the enum.<br/>
	 * If false, an Enum is serialized as a name=value pair (name=name())
	 * 
	 * @param enumAsBean
	 *            true to serialize an enum as a bean instead of as a name=value
	 *            pair (default=false)
	 */
	public void setEnumAsBean(boolean enumAsBean) {
		this.enumAsBean = enumAsBean;
	}

	protected static class JSONAnnotationFinder {
		private boolean serialize = true;
		private Method accessor;
		private String name;

		public JSONAnnotationFinder(Method accessor) {
			this.accessor = accessor;
		}

		public boolean shouldSerialize() {
			return serialize;
		}

		public String getName() {
			return name;
		}

	}

	public static void main(String[] args) throws Exception {
		Person p = new Person("xx", "dddd", 12, new Date());
		Person tmp = new Person("xx2", "dddd", 12, new Date());
		p.getChild().add(tmp);
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		tmp.getChild().add(tmp = new Person("xx2", "dddd", 12, new Date()));
		List lst = new ArrayList();
		lst.add(p);
		lst.add(p);
		lst.add(p);
		System.out.println(new JsonWriter(4,"yyyyMMdd",false).write(p));
	}

	private static class Person {
		private String name;
		private String sex;
		private int age;
		private Date birth;
		private Set child = new HashSet();

		public Person(String name, String sex, int age, Date birth) {
			this.name = name;
			this.sex = sex;
			this.age = age;
			this.birth = birth;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Date getBirth() {
			return birth;
		}

		public void setBirth(Date birth) {
			this.birth = birth;
		}

		public Set getChild() {
			return child;
		}

		public void setChild(Set child) {
			this.child = child;
		}

	}
}
