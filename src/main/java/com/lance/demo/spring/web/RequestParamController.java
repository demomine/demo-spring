package com.lance.demo.spring.web;

import com.lance.demo.spring.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/requestParam")
public class RequestParamController {
    // /requestParam/user
    @PostMapping("/user")
    @ResponseBody
    //需要添加jackson依赖
    public User hello(@RequestParam String username) throws Exception {
        User user = new User();
        user.setName(username);
        return user;
    }
}
