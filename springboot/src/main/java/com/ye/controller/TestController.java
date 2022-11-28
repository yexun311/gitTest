package com.ye.controller;

import com.ye.model.entity.UserEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/t1")
    public String test1(@Validated UserEntity userEntity, BindingResult bindingResult){

        return bindingResult.getAllErrors().toString();

    }

}
