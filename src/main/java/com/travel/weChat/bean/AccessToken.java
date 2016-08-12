package com.travel.weChat.bean;

import java.io.Serializable;

/**
 * Created by Jim Wang on 2016/8/12.
 */
public class AccessToken implements Serializable {

    private String access_token;
    private Integer expires_in;
    private Integer errcode;
    private String errmsg;

    private Long expiredTime;//过期时间

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public boolean isAvailable() {
        if (this.expiredTime == null || this.errcode != null || this.expiredTime.longValue() < System.currentTimeMillis())
            return false;
        return this.access_token != null;
    }


}