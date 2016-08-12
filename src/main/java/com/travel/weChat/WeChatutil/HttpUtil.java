package com.travel.weChat.WeChatutil;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Jim Wang on 2016/8/12.
 */
public class HttpUtil {

    private static Log logger = LogFactory.getLog(HttpUtil.class);


    public static String get(String uri) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpMethod = new HttpGet(uri);
        return praseResponse(httpclient,httpMethod);
    }

    public static String get(String uri,Map<String,String> params) throws IOException {
        if(params != null && !params.isEmpty()){
            StringBuffer buffer = null;
            if(uri.contains("?")){
                if(!uri.endsWith("&")){
                    buffer = new StringBuffer("&");
                }else{
                    buffer = new StringBuffer();
                }
            }else{
                buffer = new StringBuffer("?");
            }

            Iterator<Map.Entry<String,String>> iterator = params.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,String> entrySet = iterator.next();
                buffer.append(entrySet.getKey()).append("=").append(URLEncoder.encode(entrySet.getValue(),"UTF-8")).append("&");
            }
            uri += buffer.substring(0,buffer.length()-1);
        }
        logger.debug(uri);
        String result = get(uri);
        logger.debug(result);
        return result;
    }


    public static String post(String uri,Map<String,String> params) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setCookieSpec("").build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setConfig(requestConfig);
        if(params != null && params.size() > 0){
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for(Map.Entry<String, String> entry:params.entrySet()){
                String key = entry.getKey();
                Object value = entry.getValue();
                if(value instanceof String){
                    nvps.add(new BasicNameValuePair(key,(String)value));
                }else if(value instanceof List){
                    for(Object v:(List)value){
                        if(v instanceof String){
                            nvps.add(new BasicNameValuePair(key,(String)value));
                        }else {
                            logger.error("error value :" + v + " which key is " + key);
                        }
                    }
                }else{
                    logger.warn("unsupport type");
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        }

        return praseResponse(httpclient,httpPost);
    }

    public static String post(String uri,String entry) throws IOException {
        String result = null;

        CloseableHttpClient httpclient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom().setCookieSpec("").build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setConfig(requestConfig);

        if(StringUtils.isNotBlank(entry)){
            StringEntity reqEntity  = new StringEntity(entry,Consts.UTF_8);
            httpPost.setEntity(reqEntity);
        }
        return praseResponse(httpclient,httpPost);
    }

    public static String post(String uri,String entry,SSLConnectionSocketFactory sslsf) throws IOException {

        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        RequestConfig requestConfig = RequestConfig.custom().setCookieSpec("").build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setConfig(requestConfig);
        if(StringUtils.isNotBlank(entry)){
            StringEntity  reqEntity  = new StringEntity(entry,Consts.UTF_8);
            httpPost.setEntity(reqEntity);
        }

        return praseResponse(httpclient,httpPost);
    }

    /**
     *
     * @param httpClient
     * @param httpMethod
     * @return
     */
    private static String praseResponse(CloseableHttpClient httpClient, HttpUriRequest httpMethod){
        String result = null;
        try {
            CloseableHttpResponse response = httpClient.execute(httpMethod);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
                if (entity != null){
                    result = EntityUtils.toString(entity, Consts.UTF_8);
                }
                EntityUtils.consume(entity);
                return result;
            }
            response.close();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}