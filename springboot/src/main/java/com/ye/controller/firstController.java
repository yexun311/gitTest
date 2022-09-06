package com.ye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/springboot")
public class firstController {

    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome(){
        return "Welcome to the world of SpringBoot !";
    }

}
