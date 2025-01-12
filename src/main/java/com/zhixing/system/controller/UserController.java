package com.zhixing.system.controller;


import com.zhixing.system.pojo.Mall;
import com.zhixing.system.pojo.User;
import com.zhixing.system.service.IMallService;
import com.zhixing.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //查询
    @RequestMapping("/userList")
    public String userList(Model model){
        model.addAttribute("users", userService.list());
        return "user/userList";
    }


    //添加
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "user/userAdd";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("nickname") String nickname){
        User user = new User().setUsername(username).setPassword(password).setNickname(nickname);
        userService.save(user);
        return "redirect:/user/userList";
    }


    //修改
    @RequestMapping("/toUpdateUser/{id}")
    public String toUpdateUser(@PathVariable Integer id, Model model){
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user/userUpdate";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){
        userService.updateById(user);
        return "redirect:/user/userList";
    }

    //删除
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.removeById(id);
        return "redirect:/user/userList";
    }
}
