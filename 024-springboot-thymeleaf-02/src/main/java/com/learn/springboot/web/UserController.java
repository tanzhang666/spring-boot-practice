package com.learn.springboot.web;

import com.learn.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @RequestMapping("/userDetail/{id}")
    public String queryUserById(Model model, @PathVariable Long id){
        User user =new User();
        user.setId(id);
        user.setName("test");
        user.setAge(20);
        model.addAttribute("user",user);
        return "userDetail";
    }

    @RequestMapping("/userDetail")
    public String queryUser(Model model, @RequestParam Long id,@RequestParam String name,@RequestParam Integer age){
        User user =new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        model.addAttribute("user",user);
        return "userDetail";
    }

    @RequestMapping("property")
    public String property(){
        return "property";
    }

    @RequestMapping("url")
    public String url(Model model){
        model.addAttribute("id",1);
        model.addAttribute("name","test");
        model.addAttribute("age",20);
        return "url";
    }

//    @RequestMapping("/userDetail/{id}")
//    public ModelAndView queryUserById(@PathVariable Long id){
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
