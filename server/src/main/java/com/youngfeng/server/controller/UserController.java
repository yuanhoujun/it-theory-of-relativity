package com.youngfeng.server.controller;

import com.youngfeng.server.model.Response;
import com.youngfeng.server.model.User;
import com.youngfeng.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/login")
    public Response login(@RequestParam("username") String username, @RequestParam("pwd") String pwd) {
        Response response = new Response();

        boolean isExist = userService.isExist(username);
        if(!isExist) {
            response.setCode(Response.CODE_USER_NOT_EXIST);
            response.setMsg("用户不存在或密码错误");
        }

        User user = userService.findUser(username, pwd);

        if(null == user) {
            response.setCode(Response.CODE_USER_PWD_ERR);
            response.setMsg("用户不存在或密码错误");
        } else {
            response.setData(user);
        }

        return response;
    }

    @ResponseBody
    @PostMapping("/register")
    public Response register(@RequestParam("username") String username, @RequestParam("pwd") String pwd) {
        Response response = new Response();

        boolean isExist = userService.isExist(username);
        if(isExist) {
           response.setCode(Response.CODE_USER_HAS_EXIST);
           response.setMsg("用户名已存在");
        } else {
            userService.saveUser(username, pwd);
        }

        return response;
    }

}
