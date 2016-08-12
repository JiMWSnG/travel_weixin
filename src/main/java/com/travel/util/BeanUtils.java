package com.travel.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

/**
 * Created on 2006-10-28
 * <p>
 * Title: ���з�װ��һ��BeanUtils, �ṩSpring, Apache��BeanUtils ֮���һЩ����.
 * </p>
 * <p/>
 * Description:
 * �����ڵ�ǰ��������private/protected��Ա������private/protected�����BeanUtils.
 * ע��,��Ϊ����Ϊ��ǰ�������ı���,ͨ��̳л�õ�protected���������ܷ���,
 * ��Ҫת�͵������ñ���������ܷ���. �������������ʹ��Apache Jarkarta Commons BeanUtils
 * <p>
 * Copyright: Copyright TYDIC (c) 2006
 * </p>
 * <p>
 * Company: tydic.com
 * </p>
 * 
 * @author <a href="malito:tongys@tydic.com">ͯ��ʤ</a>
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class BeanUtils {
	private static Logger log = Logger.getLogger(BeanUtils.class);

	/**
	 * ��ȡ��ǰ��������private/protected����
	 */
	static public Object getPrivateProperty(Object object, String propertyName)
			throws IllegalAccessException, NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);
		Field field = object.getClass().getDeclaredField(propertyName);
		field.setAccessible(true);
		return field.get(object);
	}

	/**
	 * ���õ�ǰ��������private/protected����
	 */
	static public void setPrivateProperty(Object object, String propertyName,
			Object newValue) throws IllegalAccessException,
			NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);

		Field field = object.getClass().getDeclaredField(propertyName);
		field.setAccessible(true);
		field.set(object, newValue);
	}

	/**
	 * ���õ�ǰ��������private/protected����
	 */
	static public Object invokePrivateMethod(Object object, String methodName,
			Object... params) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		Assert.notNull(object);
		Assert.hasText(methodName);
		Class[] types = new Class[params.length];
		for (int i = 0; i < params.length; i++) {
			types[i] = params[i].getClass();
		}
		Method method = object.getClass().getDeclaredMethod(methodName, types);
		method.setAccessible(true);
		return method.invoke(object, params);
	}

	/**
	 * ���
	 * 
	 * @param clzss
	 * @return
	 */
	public static String getObjectToString(Class clzss) {
		Object obj;
		try {
			obj = clzss.newInstance();
			Map map = org.apache.commons.beanutils.BeanUtils.describe(obj);
			map.remove("class");
			String signature = "\npublic String toString(){\n";
			StringBuffer sb = new StringBuffer(signature);
			String newSb = "\tStringBuffer sb = new StringBuffer()\n";
			sb.append(newSb);
			for (Iterator it = map.keySet().iterator(); it.hasNext();) {
				String key = (String) it.next();
				String str = "\t\t.append(" + key + ").append(\"\\t\")\n";
				sb.append(str);
			}
			sb.append("\t;\n").append("\treturn sb.toString();\n").append("}");
			return sb.toString();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	public static void findPrimaryFieldTypeNameSet(Class clazz, Set<String> set)
			throws IntrospectionException {
		Field[] fields = clazz.getDeclaredFields();// 获得属性
		Method[] ms = clazz.getDeclaredMethods();
		for (Method getMethod : ms) {
			if (getMethod.getName().startsWith("get")) {
				if (getMethod != null) {
					Class c = getMethod.getReturnType();
					if (c.isPrimitive() || c == String.class || Date.class.isAssignableFrom(c) ) {
						String methodName = getMethod.getName();
						methodName = methodName.replaceFirst("get", "");
						methodName = toLowerCaseFirstOne(methodName);
						set.add(methodName);
					}
				}
			}
		}
	}

	// 首字母转小写
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder())
					.append(Character.toLowerCase(s.charAt(0)))
					.append(s.substring(1)).toString();
	}
}
