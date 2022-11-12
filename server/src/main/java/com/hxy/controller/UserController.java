package com.hxy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxy.entity.Company;
import com.hxy.entity.User;
import com.hxy.mapper.CompanyMapper;
import com.hxy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hxy
 * @since 2022-09-15
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CompanyMapper companyMapper;

    //user login
    @PostMapping("/login")
    @ResponseBody
    public Boolean userLogin(String username, String password, HttpServletRequest request){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).eq("password",password);
        User user = userMapper.selectOne(wrapper);
        if (user != null){
            request.getSession(true).setAttribute("userId",user.getUserId());
            return true;
        }else {
            return false;
        }

    }

    //个人信息
    @GetMapping("/info")
    @ResponseBody
    public User userInfo(HttpServletRequest request){
        Integer userId = (Integer) request.getSession(false).getAttribute("userId");
        User user = userMapper.selectById(userId);
        return user;
    }

    //修改个人信息
    @PutMapping("/updateInfo")
    @ResponseBody
    public Boolean updateInfo(User user){
        int i = userMapper.updateById(user);
        return i != -1 ? true : false;
    }

    //company login
    @PostMapping("/company/login")
    @ResponseBody
    public Boolean companyLogin(String username ,String password ,HttpServletRequest request){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).eq("password",password).eq("is_user",false);
        User user = userMapper.selectOne(wrapper);
        if (user != null){
            QueryWrapper<Company> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id",user.getUserId());
            Company company = companyMapper.selectOne(queryWrapper);
            if (company == null){
                company = new Company();
                //新建用户
                company.setUserId(user.getUserId());
                companyMapper.insert(company);
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("userId",user.getUserId());
            session.setAttribute("companyId",company.getCompanyId());
            return true;
        }
        return false;
    }

    //用户注册
    @PostMapping("/userRegister")
    @ResponseBody
    public Boolean userRegister(User user){
        user.setIsUser(1);
        int i = userMapper.insert(user);
        return i != -1 ? true: false;
    }

    //公司注册
    @PostMapping("/companyRegister")
    @ResponseBody
    public Boolean companyRegister(User user){
        user.setIsUser(0);
        int i = userMapper.insert(user);
        return i != -1 ? true: false;
    }

}
