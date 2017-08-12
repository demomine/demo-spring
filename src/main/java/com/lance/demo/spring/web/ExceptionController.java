package com.lance.demo.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exception")
public class ExceptionController {
    // /exception/hello
    @GetMapping("/hello")
    //需要添加jackson依赖
    public String hello() throws Exception {
        throw new Exception("test error");
    }
    /*@ExceptionHandler
    public ModelAndView exceptionHandler(Exception e) {
        System.out.println(e.getMessage());
        return new ModelAndView("/error");
    }*/
}
