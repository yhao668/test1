package com.xxxx.controller;

import com.xxxx.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserInfoController {

    @RequestMapping("login.do")
    public ModelAndView sayLogin(HttpSession session){
        System.out.println("登录...");
        ModelAndView mav=new ModelAndView();
        //实例化对象放在session作用域
        User user=new User(101,"历史","666");
        //存储用户的名称
        session.setAttribute("user",user);
        //成功页面
        mav.setViewName("forward:/success.jsp");
        //目标对象
        return mav;
    }

    @RequestMapping("add.do")
    public ModelAndView sayAdd(){
        System.out.println("新增...");
        ModelAndView mav=new ModelAndView();
        //成功页面
        mav.setViewName("success");
        //目标对象
        return mav;
    }

    @RequestMapping("del.do")
    public ModelAndView sayDel(){
        System.out.println("删除...");
        ModelAndView mav=new ModelAndView();
        //成功页面
        mav.setViewName("success");
        //目标对象
        return mav;
    }

    @RequestMapping("update.do")
    public ModelAndView sayUpdate(){
        System.out.println("更新...");
        ModelAndView mav=new ModelAndView();
        //成功页面
        mav.setViewName("success");
        //目标对象
        return mav;
    }
}
