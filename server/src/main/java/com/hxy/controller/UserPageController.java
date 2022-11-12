package com.hxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zzy
 * @desc
 */
@Controller
public class UserPageController {
    //用户主页
    @GetMapping("/user/index")
    public String userIndex(){
        return "index";
    }

    //所有工作页面
    @GetMapping("/user/job")
    public String userJob(){
        return "user/job";
    }

    //上传简历页面
    @GetMapping("/user/userResume")
    public String userResume(){
        return "user/userResume";
    }

    //用户个人信息
    @GetMapping("/user/userInfo")
    public String userInfo(){
        return "user/userInfo";
    }

    //用户投递的工作
    @GetMapping("/user/userSend")
    public String userSend(){
        return "user/userSend";
    }

    //用户收到的offer
    @GetMapping("/user/userOffer")
    public String userOffer(){
        return "user/userOffer";
    }

    //个人简历页面
    @GetMapping("/user/userResumeInfo")
    public String userResumeInfo(){
        return "user/userResumeInfo";
    }

    //退出
    @GetMapping("/user/exit")
    public String userExit(HttpServletRequest request){
        request.getSession(false).removeAttribute("userId");
        return "index";
    }

    //用户登录页面
    @GetMapping("/user/userLogin")
    public String userLogin(){
        return "user/userLogin";
    }

    //用户注册页面
    @GetMapping("/user/userRegister")
    public String userRegister(){
        return "user/userRegister";
    }


}
