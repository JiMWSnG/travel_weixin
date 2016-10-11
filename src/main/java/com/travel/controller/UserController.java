package com.travel.controller;

import com.travel.service.UserService;
import com.travel.web.Response;
import com.travel.web.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jim Wang on 2016/8/1.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @ResponseBody
    @RequestMapping("/userInfo")
    public Response getUserInfo(@RequestParam(value="id") int  id ) throws Exception{
      //  String  idStr = request.getParameter("id");
       // Integer id =11;
      //  Integer id = null;

        return userService.getUserInfo(id);


    }
}
