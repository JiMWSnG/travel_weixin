package com.peanutbox.util;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonFilter;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 根据传入对象转化为JSON格式
 * 
 * @date 2014/01/13
 */

public class JsonUtil {
	private static final Log log = LogFactory.getLog(JsonUtil.class);

	  private static ObjectMapper MAPPER;

	    static {
	        MAPPER = generateMapper(Inclusion.NON_NULL);
	    }

	    private JsonUtil() {
	    }
	    //liangpeng.
	    public static String obj2Json(Object obj)throws Exception{
	    	return obj2Json(obj,3);
	    }
	    public static String obj2Json(Object obj,int maxDepth,String dateFormat)throws Exception{
	    	return new JsonWriter(maxDepth,dateFormat).write(obj);
	    }
	    public static String obj2Json(Object obj,int maxDepth,String dateFormat,boolean containsCollection)throws Exception{
	    	return new JsonWriter(maxDepth,dateFormat,containsCollection).write(obj);
	    }
	    //传入最大层级:默认只转换一级的数组,3级对象(Map)array/iteratable不算做对象,maxDepth可指定最大对象级数
	    //原则此值不能太大,一般不大于4(分页框架中的对象如果有码表则要4级)一般3般可用,视实际需要越小越好(1-4)
	    public static String obj2Json(Object obj,int maxDepth)throws Exception{
	    	return new JsonWriter(maxDepth).write(obj);
	    }
	    
	    /**
	     * 将json通过类型转换成对象
	     *
	     * <pre>
	     *     {@link JsonUtil JsonUtil}.fromJson("{\"username\":\"username\", \"password\":\"password\"}", User.class);
	     * </pre>
	     *
	     * @param json json字符串
	     * @param clazz 泛型类型
	     * @return 返回对象
	     * @throws IOException
	     */
	    public static <T> T fromJsonToObject(String json, Class<T> clazz) throws IOException {
	        return clazz.equals(String.class) ? (T) json : MAPPER.readValue(json, clazz);
	    }
	    
	    /**
	     * 转换json到map
	     * @param json
	     * @return
	     * @throws IOException
	     */
	    public static <T> Map<String, T> fromJsonToMap(String json){
	        try {
				return MAPPER.readValue(json, Map.class);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
	    }

	    /**
	     * 将json通过类型转换成对象
	     *
	     * <pre>
	     *     {@link JsonUtil JsonUtil}.fromJson("[{\"username\":\"username\", \"password\":\"password\"}, {\"username\":\"username\", \"password\":\"password\"}]", new TypeReference&lt;List&lt;User&gt;&gt;);
	     * </pre>
	     *
	     * @param json json字符串
	     * @param typeReference 引用类型
	     * @return 返回对象
	     * @throws IOException
	     */
	    public static <T> T fromJsonToObject(String json, TypeReference<?> typeReference) throws IOException {
	        return (T) (typeReference.getType().equals(String.class) ? json : MAPPER.readValue(json, typeReference));
	    }

	    /**
	     * 将对象转换成json, 包含所有属性, 包括关联对象
	     *
	     * <pre>
	     *     {@link JsonUtil JsonUtil}.toJson(user);
	     * </pre>
	     *
	     * @param src 对象
	     * @return 返回json字符串
	     * @throws IOException
	     */
	    public static <T> String toJson(T src) {
	    	try {
	    		return src instanceof String ? (String) src : MAPPER.writeValueAsString(src);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
	    }

	    /**
	     * 将对象转换成json, 可以设置输出属性
	     *
	     * <pre>
	     *     {@link JsonUtil JsonUtil}.toJson(user, {@link Inclusion Inclusion.ALWAYS});
	     * </pre>
	     *
	     * {@link Inclusion Inclusion 对象枚举}
	     * <ul>
	     *     <li>{@link Inclusion Inclusion.ALWAYS 全部列入}</li>
	     *     <li>{@link Inclusion Inclusion.NON_DEFAULT 字段和对象默认值相同的时候不会列入}</li>
	     *     <li>{@link Inclusion Inclusion.NON_EMPTY 字段为NULL或者""的时候不会列入}</li>
	     *     <li>{@link Inclusion Inclusion.NON_NULL 字段为NULL时候不会列入}</li>
	     * </ul>
	     *
	     * @param src 对象
	     * @param inclusion 传入一个枚举值, 设置输出属性
	     * @return 返回json字符串
	     * @throws IOException
	     */
	    public static <T> String toJson(T src, Inclusion inclusion) throws IOException {
	        if (src instanceof String) {
	            return (String) src;
	        } else {
	            ObjectMapper customMapper = generateMapper(inclusion);
	            return customMapper.writeValueAsString(src);
	        }
	    }
	    
	    private static Class getClassByFieldName(Class clazz ,String fieldName) throws NoSuchFieldException, SecurityException{
	    	Field f = clazz.getDeclaredField(fieldName);
	    	return f.getType();
	    }
	    /**
	     * 根据过滤器, 将对象转换成json字符串格式
	     * <br/>属性支持 xxx.yyy
	     * @param obj 需要转换的对象
	     * @clazz clazz 需要过滤的类(注意，需要在要转换的对象中定义JsonFilter注解)
	     * @param properties 需要过滤类的属性
	     */
	    public static String toJsonStrWithFilter(Object obj, Class clazz,String ... properties) {
	    		Map<Class, Set<String>> map = new HashMap<Class, Set<String>>();
	    		for (int i = 0; i < properties.length; i++) {
	    			Class relClass = null;
	    			String fieldName = null;
	    			if (properties[i].contains(".")) {
	    				String[] splits = properties[i].split("\\.");
	    				try {
							relClass = getClassByFieldName(clazz, splits[0]);
						} catch (NoSuchFieldException e) {
							throw new RuntimeException(e);
						}
	    				fieldName = splits[1];
	    			} else {
	    				relClass = clazz;
	    				fieldName = properties[i];
	    			}
	    			Set<String> set = map.get(relClass);
	    			if (set == null) {
	    				set = new HashSet<String>();
	    				map.put(relClass, set);
	    			}
	    			set.add(fieldName);
	    		}
	    		return toJsonStrWithFilters(obj, map);
	    }
	    
	    /**
	     * 传入一个Map, key 应该为类, value 为该类想要的属性Set集合
	     * @param obj
	     * @param map
	     * @return
	     */
	    public static String toJsonStrWithFilters(Object obj, Map<Class, Set<String>> map) {
	    	try {
	    		ObjectMapper customMapper = generateMapper(Inclusion.NON_NULL);
	    		SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
	    		for(Entry<Class, Set<String>> entry : map.entrySet()){
	    			simpleFilterProvider.addFilter(
	    					AnnotationUtils.getValue(
	    							AnnotationUtils.findAnnotation(entry.getKey(), JsonFilter.class))
	    							.toString(), SimpleBeanPropertyFilter
	    							.filterOutAllExcept(entry.getValue()));
	    		}
	    		return customMapper.filteredWriter(simpleFilterProvider).writeValueAsString(obj);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	    }
	    /**
	     * 将对象转换成json字符串格式
	     * 
	     * @param obj 需要转换的对象
	     * @clazz1 clazz1 需要过滤的类(注意，需要在要转换的对象中定义JsonFilter注解)
	     * @param properties 需要过滤类的属性
	     * @throws IntrospectionException 
	     */
	    public static String toJsonStrWithAllPrimaryPropery(Object obj, Class clazz) {
	    	Set<String> sets = new HashSet<String>();
	    	try {
				BeanUtils.findPrimaryFieldTypeNameSet(clazz, sets);
			
	    	ObjectMapper customMapper = generateMapper(Inclusion.NON_NULL);
	    	return customMapper.filteredWriter(
	                new SimpleFilterProvider().addFilter(
	                		AnnotationUtils.getValue(
	                                AnnotationUtils.findAnnotation(clazz, JsonFilter.class))
	                                .toString(), SimpleBeanPropertyFilter
	                                .filterOutAllExcept(sets)))
	                .writeValueAsString(obj);
	    	} catch (Exception e) {
				throw new RuntimeException(e);
			}
	    }

	    /**
	     * 将对象转换成json字符串格式
	     * 
	     * @param value 需要转换的对象(注意，需要在要转换的对象中定义JsonFilter注解)
	     * @param properties2Exclude  需要排除的属性
	     */
	    public static String toJsonStrWithExcludeProperties(Object obj, Class clazz, String ... properties2Exclude) {
	    	try {
	    		ObjectMapper customMapper = generateMapper(Inclusion.NON_NULL);
	    		return customMapper.filteredWriter(
	    				new SimpleFilterProvider().addFilter(
	    						AnnotationUtils.getValue(
	    								AnnotationUtils.findAnnotation(clazz, JsonFilter.class))
	    								.toString(), SimpleBeanPropertyFilter
	    								.serializeAllExcept(properties2Exclude)))
	    								.writeValueAsString(obj);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

	    }

	    /**
	     * 将对象转换成json, 传入配置对象
	     *
	     * <pre>
	     *     {@link ObjectMapper ObjectMapper} mapper = new ObjectMapper();
	     *     mapper.setSerializationInclusion({@link Inclusion Inclusion.ALWAYS});
	     *     mapper.configure({@link Feature Feature.FAIL_ON_UNKNOWN_PROPERTIES}, false);
	     *     mapper.configure({@link Feature Feature.FAIL_ON_NUMBERS_FOR_ENUMS}, true);
	     *     mapper.setDateFormat(new {@link SimpleDateFormat SimpleDateFormat}("yyyy-MM-dd HH:mm:ss"));
	     *     {@link JsonUtil JsonUtil}.toJson(user, mapper);
	     * </pre>
	     *
	     * {@link ObjectMapper ObjectMapper}
	     *
	     * @see ObjectMapper
	     *
	     * @param src 对象
	     * @param mapper 配置对象
	     * @return 返回json字符串
	     * @throws IOException
	     */
	    public static <T> String toJson(T src, ObjectMapper mapper) throws IOException {
	        if (null != mapper) {
	            if (src instanceof String) {
	                return (String) src;
	            } else {
	                return mapper.writeValueAsString(src);
	            }
	        } else {
	            return null;
	        }
	    }

	    /**
	     * 通过Inclusion创建ObjectMapper对象
	     *
	     * {@link Inclusion Inclusion 对象枚举}
	     * <ul>
	     *     <li>{@link Inclusion Inclusion.ALWAYS 全部列入}</li>
	     *     <li>{@link Inclusion Inclusion.NON_DEFAULT 字段和对象默认值相同的时候不会列入}</li>
	     *     <li>{@link Inclusion Inclusion.NON_EMPTY 字段为NULL或者""的时候不会列入}</li>
	     *     <li>{@link Inclusion Inclusion.NON_NULL 字段为NULL时候不会列入}</li>
	     * </ul>
	     *
	     * @param inclusion 传入一个枚举值, 设置输出属性
	     * @return 返回ObjectMapper对象
	     */
	    private static ObjectMapper generateMapper(Inclusion inclusion) {
	        ObjectMapper customMapper = new ObjectMapper();
	        // 设置输出时包含属性的风格
	        customMapper.getSerializationConfig().setSerializationInclusion(inclusion);

	        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
	        customMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	        // 禁止使用int代表Enum的order()來反序列化Enum,非常危險
	        customMapper.configure(Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);

	        // 所有日期格式都统一为以下样式
	        customMapper.getSerializationConfig().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));  
	        customMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false); 
	        return customMapper;
	    }
}