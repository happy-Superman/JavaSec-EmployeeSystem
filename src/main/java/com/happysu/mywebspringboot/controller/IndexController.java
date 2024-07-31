package com.happysu.mywebspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//首页控制
@Controller
public class IndexController {


    //这个可以被视图配置文件取代
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

    //测试代码
//    @RequestMapping({"/test","/"})
//    public String index(Model model){
//        model.addAttribute("msg", "<h1>hello, springboot</h1>");
//
//        model.addAttribute("users", Arrays.asList("happySu", "is", "your dad"));
//        return "test";   //这个地方是会在thymeleaf的渲染下 自动补充前缀路径去templates找 后缀是.html
//    }
}
