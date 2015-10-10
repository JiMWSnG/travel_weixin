package com.peanutbox.context;

public class SpringBeanInvoker {
	public static Object getBean(String beanName){
		return ContextHolder.getSpringContext().getBean(beanName);
	}
}
