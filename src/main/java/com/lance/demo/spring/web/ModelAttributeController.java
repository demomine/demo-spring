package com.lance.demo.spring.web;

import com.lance.demo.spring.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/model_attribute")
public class ModelAttributeController {

    @GetMapping("/hello")
    @ResponseBody
    public String getUser() {
        return "hello";
    }
    //URI 模板变量也能自动绑定到命令对象中
    // /model_attribute/user?name=lance&age=10
    @GetMapping("/user")
    @ResponseBody
    public String getUser(@ModelAttribute User user) {
        return user.toString();
    }

    // /model_attribute/user/lance?age=10
    @GetMapping("/user/{name}")
    @ResponseBody
    public String getUserDeep(@ModelAttribute User user) {
        return user.toString();
    }

    // /model_attribute/user/rsp?lance&age=10
    //@ModelAttribute 注解的返回值会覆盖@RequestMapping 注解方法中的@ModelAttribute 注解的同名命令对象
    @GetMapping("/user/rsp")
    public @ModelAttribute("user2") User getUserRsp(@ModelAttribute User user) {
        return user;
    }


}
