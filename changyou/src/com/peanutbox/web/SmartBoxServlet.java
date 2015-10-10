package com.peanutbox.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.peanutbox.context.SpringBeanInvoker;
import com.peanutbox.service.ExchangeService;

public class SmartBoxServlet extends HttpServlet {

	private static Logger logger = Logger.getLogger(SmartBoxServlet.class);
	private ExchangeService service = (ExchangeService)SpringBeanInvoker.getBean("exchangeService");

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.debug("HttpGet,客户端IP:" + request.getRemoteAddr() + ",端口:" + request.getRemotePort());
		response.setContentType("text/xml; charset=UTF-8");
		response.getWriter().write("<reponse>不支持Http Get协议,请用POST方法</reponse>");
		response.getWriter().flush();
		response.getWriter().close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Http post,客户端IP:" + request.getRemoteAddr() + ",端口:"
				+ request.getRemotePort());
		String retXml = service.service(getInputParameter(request));
		response.setContentType("text/xml; charset=UTF-8");
		response.getWriter().write(retXml);
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * 取得输入参数
	 * 
	 * @param request
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	private String getInputParameter(HttpServletRequest request) throws ServletException, IOException {
		// 统一用UTF-8的编码格式
		BufferedReader br = new BufferedReader(new InputStreamReader(request
				.getInputStream(), "UTF-8"));
		String line = null;
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

}
