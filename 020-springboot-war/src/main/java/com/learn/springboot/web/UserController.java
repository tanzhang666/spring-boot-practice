package com.learn.springboot.web;


import com.learn.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/userDetail")
    public String userDetail(Model model){
        User user=new User();
        user.setId(1L);
        user.setName("test");
        user.setAge(20);
        model.addAttribute("user",user);
        return "index";
    }
}
