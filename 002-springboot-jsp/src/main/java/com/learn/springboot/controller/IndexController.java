package com.learn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/mv")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("mv");
        mv.addObject("data","hello spring boot");
        return mv;
    }

    @RequestMapping("/str")
    public String say(Model model){
        model.addAttribute("data","hello spring boot");
        return "str";
    }

}
