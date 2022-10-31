package com.ye.exception;

import com.ye.common.result.HttpStatusEnum;
import com.ye.common.result.Result;
import com.ye.common.result.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常
 */
/* @RestControllerAdvice 主要配合@ExceptionHandler使用，统一处理异常情况。
1、@RestControllerAdvice 注解，可以用于定义@ExceptionHandler、@InitBinder、@ModelAttribute，并应用到所有@RequestMapping中。
2、@RestControllerAdvice 是组件注解，他使得其实现类能够被classpath扫描自动发现，如果应用是通过MVC命令空间或MVC Java编程方式配置，那么该特性默认是自动开启的。*/
@RestControllerAdvice
public class GlobalException {

    private final Logger log = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(FailException.class)
    public ResponseEntity<ResultSet<Void>> failExceptionHandle(FailException e){
        log.error(e.getMessage(), e);
        String msg = e.getMessage();
        if (msg == null || "".equals(msg))
            msg = HttpStatusEnum.FAIL.getMessage();
        return ResponseEntity
                .status(HttpStatusEnum.SUCCESS.getHttpCode())
                .body(Result.fail(HttpStatusEnum.FAIL, msg));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultSet<Void>> exceptionHandle(Exception e){
        log.error(e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatusEnum.SUCCESS.getHttpCode())
                .body(Result.fail(HttpStatusEnum.SYSTEM_EXCEPTION));
    }

}
