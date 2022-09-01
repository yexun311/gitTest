package com.ye.controller;

import com.alibaba.fastjson.JSON;
import com.ye.pojo.AD;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ADController {

    @Resource
    AD ad;

    @ResponseBody
    @GetMapping("/ad")
    public String AD(){

        return JSON.toJSONString(ad);
    }
}
