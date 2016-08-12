package com.travel.controller;

import com.travel.service.UserService;
import com.travel.web.LoginRequest;
import com.travel.web.RegisterRequest;
import com.travel.web.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Jim Wang on 2016/8/1.
 */
@Controller
public class LoginController {
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Resource
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Response Login(LoginRequest loginRequest, HttpServletRequest httpServletRequest) throws Exception{
        Response response = userService.Login(loginRequest);
        if(response.isSuccess()){
            HttpSession session =httpServletRequest.getSession();
            session.setAttribute("login",loginRequest);
            session.setAttribute("userId",response.getData());

        }
        return response;

    }
    @ResponseBody
    @RequestMapping(value ="/logout",method = RequestMethod.POST)
    public Response Logout()throws  Exception{
        return new Response();
    }
    @ResponseBody
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public Response register(RegisterRequest registerRequest){
        //TODO:注册完直接登录
       return  userService.register(registerRequest);

    }

}
