package com.travel.service.impl;

import com.travel.bean.Account;
import com.travel.bean.User;
import com.travel.contants.Contants;
import com.travel.dao.AccountDao;
import com.travel.dao.UserDao;
import com.travel.service.UserService;
import com.travel.util.MD5Util;
import com.travel.util.RandomStringUtil;
import com.travel.web.LoginRequest;
import com.travel.web.RegisterRequest;
import com.travel.web.Response;
import com.travel.web.UserRequest;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jim Wang on 2016/8/1.
 */

public class UserServiceImpl implements UserService {
    private AccountDao accountDao;
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Response Login(LoginRequest loginRequest) {
        Response response = new Response();
        //TODO:
        //得到登陆信息；
        String username = loginRequest.getUsername();
        String passwd = loginRequest.getPasswd();
        String authorization = loginRequest.getAuthorization();
        //验证服务器token
        String token = loginRequest.getToken();
        if(!Contants.TRAVEL_TOKEN.equals(token)){
            //token 不正确，拒绝登陆
            response.setSuccess(false);
            response.setCode(Contants.TOKEN_ERROR_CODE);
            response.setMsg("token错误");
            return response;
        }


        //验证验证码


        //验证用户名格式
        if(!checkUsername(username)){
            response.setSuccess(false);
            response.setCode(Contants.USERNAME_ERROR_CODE);
            response.setMsg("用户名格式不正确");
            return response;
        }
        //验证密码
        //验证权限
        int isvalid = valid(username,passwd,authorization);
        //登陆，统计信息，更新session
        if(isvalid < 0){
            response.setSuccess(false);
            response.setCode(isvalid);
            response.setMsg("密码不正确或权限不足或用户没找到");
            return response;
        }
       //在controller做
        // httpRequest.getSession().setAttribute("user",loginRequest);
        response.setSuccess(true);
        response.setData(isvalid);
        return response;
    }

    @Override
    public Response Logout() {
        return null;
    }

    @Override

    public Response register(RegisterRequest registerRequest) {
        Response response = new Response();
        String username = registerRequest.getUsername();
        if(!checkUsername(username)){
            response.setSuccess(false);
            response.setCode(Contants.USERNAME_ERROR_CODE);
            response.setMsg("用户名格式不正确!");
            return response;
        }
        if(exist(username)){
            response.setSuccess(false);
            response.setCode(Contants.USERNAME_ERROR_CODE);
            response.setMsg("用户名已存在!");
            return response;
        }
        //自动生成一个user
        String name = RandomStringUtil.getRandomString3(11);
        String phone = registerRequest.getPhone();
        String email = registerRequest.getEmail();
        String lastIp = registerRequest.getLastIp();
        String deviceType =registerRequest.getDeviceType();
        Long nowTime = new Date().getTime()/1000;
        User user = new User(0,name,1,0,phone,email,
                            null,nowTime,lastIp,deviceType,0,0);
        if(userDao.add(user)<0){
            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
            response.setMsg("数据库故障!");
            return response;
        }
        int userId = user.getId();
        Account account =registerRequest;
        account.setUserId(userId);
        account.setAuthorization(Contants.AUTHORIZATION_NORMAL);
        String salt =RandomStringUtil.getRandomString3(8);
        account.setValidCode(salt);
        String passwd = registerRequest.getPasswd();
        //加密
        passwd = MD5Util.getMD5String(passwd+salt);
        account.setPasswd(passwd);
        if(accountDao.addAccount(account)<=0){
            userDao.remove(userId);
            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
            response.setMsg("数据库故障!");
            return response;
        }
        response.setSuccess(true);
        response.setData(userId);
        return response;




    }

    private boolean checkUsername(String username){
        String usernameRex ="^[a-zA-Z][a-z0-9_-]{3,15}$";//字母开头，允许包含_或-,长度3-15
        int len = username.trim().length();
        Pattern pattern = Pattern.compile(usernameRex);
        Matcher matcher = pattern.matcher(username);
        return !(len > 15 || len < 3 || !matcher.matches());

    }

    /**
     *
     * @param username
     * @param passwd
     * @param authorization
     * @return true:userId,false:error_code,0
     */
    private int  valid(String username,String passwd,String authorization){
        Account account= null;
        try{
            account =accountDao.queryByUsername(username);
        }catch (Exception e){
            return Contants.DB_ERROR_CODE;
        }
        if(account==null){
           return Contants.USERNAME_ERROR_CODE;
        }
        passwd = MD5Util.getMD5String(passwd+account.getValidCode());
        if(passwd==null||!passwd.equals(account.getPasswd())){
            return Contants.PASSWD_ERROR_CODE;
        }
        if(authorization==null||!authorization.equals(account.getAuthorization())){
            return Contants.AUTHORIZATION_ERROR_CODE;
        }
        if(account.getUserId()!=null){

            return account.getUserId();
        }
        return 0;
    }

    private boolean exist(String username){
        try{
            Account account =accountDao.queryByUsername(username);
            return account != null;
        }catch (Exception e){
            //数据库异常，重复性检测为真
            return true;
        }
    }

    public Response getUserInfo(Integer id) {
        Response response = new Response();
        try {
            User user = userDao.queryById(id);
            if (user !=null){
                response.setData(user);
                response.setSuccess(true);
                return  response;
            }
            response.setMsg("用户信息为空");
        } catch (SQLException e) {
            e.printStackTrace();
            response.setMsg("连接数据库失败");
        }
        response.setCode(Contants.DB_ERROR_CODE);
        response.setSuccess(false);
        return response;

    }

    public Response updateUserInfo(UserRequest userRequest) {
        Response response = new Response();
        User user = userRequest;
        try {
           int userId =  userDao.update(userRequest);
            if(userId > 0){
                response.setSuccess(true);
                response.setData(userId);
                return response;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setSuccess(false);
        response.setCode(Contants.DB_ERROR_CODE);
        return response;
    }
}
