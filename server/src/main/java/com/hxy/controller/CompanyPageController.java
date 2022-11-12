package com.hxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zzy
 * @desc
 */
@Controller
public class CompanyPageController {
    //公司用户注册页面
    @GetMapping("/company/companyRegister")
    public String companyRegister(){
        return "company/companyRegister";
    }

    //公司用户登录页面
    @GetMapping("/company/companyLogin")
    public String companyLogin(){
        return "company/companyLogin";
    }

    //公司主页
    @GetMapping("/company/index")
    public String compangyIndex(){
        return "company/index";
    }

    //公司信息页面
    @GetMapping("/company/companyInfo")
    public String companyInfo(){
        return "company/companyInfo";
    }

    //公司添加职位页面
    @GetMapping("/company/addPosition")
    public String addPosition(){
        return "company/addPosition";
    }

    //公司职位投递用户页面
    @GetMapping("/company/userMananger")
    public String userMananger(){
        return "company/userMananger";
    }
    //公司所有职位页面
    @GetMapping("/compangy/companyJob")
    public String companyJob(){
        return "company/companyJob";
    }

    //退出公司系统
    @GetMapping("/company/exit")
    public String companyExit(HttpServletRequest request){
        request.getSession(false).removeAttribute("userId");
        request.getSession(false).removeAttribute("companyId");
        return "redirect:/company/companyLogin";
    }
}
