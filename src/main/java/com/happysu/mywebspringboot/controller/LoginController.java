package com.happysu.mywebspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
//    @ResponseBody  要去掉 否则返回的值无法跳转界面
    //接收前端name字段中的值 作为参数
    public String login(@RequestParam("username")String username, @RequestParam("password")String password,
                        Model model, HttpSession session){  //这里的Model是用于回显数据  将数据从控制器传递到视图，以便在视图中进行渲染。

        //具体的业务：判断用户名是否正确
        if(!StringUtils.isEmpty(username)&&password.equals("123")){   //在java中 注意字符串的比较 不能使用双等号 而是应该用equals
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";   //直接跳转界面  避免登录后的url带参数值
        }
        else{
            //告诉用户，你登录失败了
            model.addAttribute("msg","用户名或密码错误");
            return "index";  //退回主页面

        }

    }

    //注销
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:index.html";

    }
}
