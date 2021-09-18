package com.zz.springboot.controller;

import com.zz.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    // @ResponseBody
    // @ExceptionHandler(UserNotExistException.class)
    // public Map<String, Object> handleException(Exception e) {
    //     Map<String, Object> map = new HashMap<>();
    //     map.put("code", "user.notexist");
    //     map.put("message", e.getMessage());
    //     return map;
    // }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        //设置响应状态码  传入4xx 5xx 有对应的模板引擎处理
        request.setAttribute("javax.servlet.error.status_code", 500);

        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());

        request.setAttribute("ext", map);

        //请求转发到error springboot默认errorController会处理error请求，分为返回页面和json两种
        return "forward:/error";
    }
}
