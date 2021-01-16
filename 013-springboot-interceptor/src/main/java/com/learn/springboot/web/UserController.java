package com.learn.springboot.web;

import com.learn.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//controller注解地址不起作用 加requestMapping注解指定路径
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login")
    public @ResponseBody Object login(HttpServletRequest request){
        User user = new User();
        user.setId(1L);
        user.setName("test");
        user.setAge(22);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        return "login success";
    }

    //该请求需要用户登陆后才可以访问
    @RequestMapping(value = "/center")
    public @ResponseBody Object center(){
        return "see center message";
    }

    //该请求不需要登陆可随意访问
    @RequestMapping(value = "/out")
    public @ResponseBody Object out(){
        return "out";
    }

    //用户未登录 但访问了需要登陆的页面所跳转的页面
    @RequestMapping(value = "/error")
    public @ResponseBody Object error(){
        return "error";
    }

}
