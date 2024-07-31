package com.happysu.mywebspringboot.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器 避免一些网站越权登录
 * return true 就是放行
 * return false 就是不放行
 * 记得去MyMvcConfig中配置拦截器
 * 此外和LoginController层有交互
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后  应该有用户的session 首先在Controller层 设置一个session  然后再这里进行申请
        Object loginUser = request.getSession().getAttribute("loginUser");

        //用户没有登录 上面没有请求到session值
        if(loginUser == null){
            //给点提示消息
            request.setAttribute("msg", "没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);  //转发 回到登录
            return false;
        }
        else{
            return true;
        }


    }
}
