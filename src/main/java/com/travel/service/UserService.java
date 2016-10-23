package com.travel.service;

import com.travel.web.LoginRequest;
import com.travel.web.RegisterRequest;
import com.travel.web.Response;
import com.travel.web.UserRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jim Wang on 2016/8/1.
 */
public interface UserService {
    Response Login(LoginRequest loginRequest);
    Response Logout();
    Response register(RegisterRequest registerRequest);
    //用户信息
    Response getUserInfo(Integer id );

    /**
     * 优先提供opneId，必须提供openID/id
     * @param userRequest
     * @return  Response,userId/-1
     */
    Response updateUserInfo(UserRequest userRequest);

}
