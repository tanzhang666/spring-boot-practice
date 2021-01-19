package com.learn.springboot.web;

import com.learn.springboot.mode.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @RequestMapping("/userList")
    public String queryUserList(Model model){
        List<User> users=new ArrayList<>();
        users.add(new User(1L,"test",20));
        users.add(new User(2L,"test",20));
        users.add(new User(3L,"test",20));
        users.add(new User(4L,"test",20));
        model.addAttribute("userList",users);
        return "userList";
    }

    @RequestMapping("/userMap")
    public String queryUserMap(Model model){
        Map<Long,User> users=new HashMap<>();
        users.put(1L,new User(1L,"test",20));
        users.put(2L,new User(2L,"test",20));
        users.put(3L,new User(3L,"test",20));
        users.put(4L,new User(4L,"test",20));
        model.addAttribute("userMap",users);
        return "userMap";
    }

    @RequestMapping("/userArray")
    public String queryUserArray(Model model){
        User[] users=new User[4];
        users[0]=new User(1L,"test",20);
        users[1]=new User(2L,"test",20);
        users[2]=new User(3L,"test",20);
        users[3]=new User(4L,"test",20);
        model.addAttribute("userArray",users);
        return "userArray";
    }

    @RequestMapping("/complexList")
    public String queryUserComplexList(Model model){
        List<Map<Integer,List<User>>> list=new ArrayList<>();
        Map<Integer,List<User>> map1=new HashMap<>();
        List<User> userList1=new ArrayList<>();
        userList1.add(new User(1L,"test",20));
        userList1.add(new User(2L,"test",20));
        userList1.add(new User(3L,"test",20));
        userList1.add(new User(4L,"test",20));
        List<User> userList2=new ArrayList<>();
        userList2.add(new User(1L,"test",20));
        userList2.add(new User(2L,"test",20));
        userList2.add(new User(3L,"test",20));
        userList2.add(new User(4L,"test",20));
        model.addAttribute("userList",userList2);
        map1.put(1,userList1);
        map1.put(2,userList2);
        Map<Integer,List<User>> map2=new HashMap<>();
        List<User> userList3=new ArrayList<>();
        userList3.add(new User(1L,"test",20));
        userList3.add(new User(2L,"test",20));
        userList3.add(new User(3L,"test",20));
        userList3.add(new User(4L,"test",20));
        List<User> userList4=new ArrayList<>();
        userList4.add(new User(1L,"test",20));
        userList4.add(new User(2L,"test",20));
        userList4.add(new User(3L,"test",20));
        userList4.add(new User(4L,"test",20));
        map2.put(1,userList3);
        map2.put(2,userList4);
        list.add(map1);
        list.add(map2);
        model.addAttribute("complexList",list);
        return "complexList";
    }

}
