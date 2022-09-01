package com.ye.service;

public class LoginServiceImpl implements LoginService{

    @Override
    public String login(String username,String password) {
        if(username.equals("admin") && password.equals("123456"))
            return "success";
        return "fail";
    }
}
