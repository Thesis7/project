package com.zhixing.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhixing.system.pojo.User;
import com.zhixing.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    // 登录
    @RequestMapping("/user/login")
    public String login(HttpServletRequest request,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", password);
        User user = userService.getOne(queryWrapper);

        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginUsername", username);
            return "redirect:/mall/mallList";
        }

        model.addAttribute("msg", "用户名或密码不正确");
        return "login";
    }

    // 注销
    @RequestMapping("/user/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }

}
