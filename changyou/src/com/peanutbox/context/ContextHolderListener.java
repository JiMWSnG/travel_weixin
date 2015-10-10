package com.peanutbox.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;



/**
 * web.xml启动时候注册spring context
 * 而后使用者可以通过SpringBeanInvoker直接调用服务
 * web.xml配置例子:
 * 	<listener>
 *		<listener-class>
 *			 com.peanutbox.context.ContextHolderListener
 *		</listener-class>
 *	</listener>
 *
 */
public class ContextHolderListener extends ContextLoaderListener {

	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}

	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ServletContext context = event.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		ContextHolder.setApplicationContext(ctx);
	}
}
