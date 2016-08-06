package com.travel.web;

import com.travel.bean.Account;
import com.travel.bean.User;

/**
 * Created by Jim Wang on 2016/8/3.
 */
public class RegisterRequest extends Account {
    private String token;
    private String email;
    private String lastIp;
    private String deviceType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
