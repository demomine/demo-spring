package com.lance.demo.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/demo")
public class WebController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() throws Exception {
        return "hello world!";
    }

    @GetMapping("/util")
    @ResponseBody
    public String util(HttpServletRequest httpRequest) throws Exception {
        WebApplicationContext webApplicationContext = RequestContextUtils.findWebApplicationContext(httpRequest);
        return webApplicationContext.getServletContext().getRealPath("/util");
    }

    @GetMapping("/user")
    public String getUser() {
        return "user";
    }


}
