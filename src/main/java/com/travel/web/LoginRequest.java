package com.travel.web;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jim Wang on 2016/8/1.
 */
public  class LoginRequest implements Request {
    private String username;
    private String passwd;
    private String CAPTCHA;
    private String authorization;
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getCAPTCHA() {
        return CAPTCHA;
    }

    public void setCAPTCHA(String CAPTCHA) {
        this.CAPTCHA = CAPTCHA;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
