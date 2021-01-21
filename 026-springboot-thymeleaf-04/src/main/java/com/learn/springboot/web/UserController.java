package com.learn.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/condition")
    public String condition(Model model)
    {
        model.addAttribute("id","89757");
        model.addAttribute("username","打工人");
        model.addAttribute("sex",1);
        model.addAttribute("flag",true);
        model.addAttribute("stat",0);
        model.addAttribute("totalPage",100);
        model.addAttribute("currentPage",1);
        return "condition";
    }
}
