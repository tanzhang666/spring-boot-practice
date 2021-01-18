package com.learn.springboot.web;

import com.learn.springboot.model.User;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("/userDetail/{id}")
    public String queryUser(Model model, @PathVariable Long id){
        User user =new User();
        user.setId(id);
        user.setName("test");
        user.setAge(20);
        model.addAttribute("user",user);
        return "userDetail";
    }

//    @RequestMapping("/userDetail/{id}")
//    public ModelAndView queryUser(@PathVariable Long id){
//        User user =new User();
//        user.setId(id);
//        user.setName("test");
//        user.setAge(20);
//        ModelAndView mv=new ModelAndView();
//        mv.setViewName("userDetail");
//        mv.addObject("data",user);
//        return mv;
//    }
}
