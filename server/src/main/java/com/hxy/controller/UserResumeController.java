package com.hxy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxy.entity.UserResume;
import com.hxy.mapper.UserResumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hxy
 * @since 2022-09-15
 */
@Controller
@RequestMapping("/userResume")
public class UserResumeController {

    @Autowired
    private UserResumeMapper userResumeMapper;

    //添加简历
    @PostMapping("/add")
    @ResponseBody
    public Boolean addResume(UserResume userResume, HttpServletRequest request){
        Integer userId = (Integer) request.getSession(false).getAttribute("userId");
        userResume.setUserId(userId);
        int insert = userResumeMapper.insert(userResume);
        return  insert != -1 ? true : false;
    }

    //修改简历
    @PutMapping("/update")
    @ResponseBody
    public Boolean updateResume(UserResume userResume , HttpServletRequest request){
        Integer userId = (Integer) request.getSession(false).getAttribute("userId");
        userResume.setUserId(userId);
        int insert = userResumeMapper.updateById(userResume);
        return  insert != -1 ? true : false;
    }

    //获取用户简历信息
    @GetMapping("/info")
    @ResponseBody
    public UserResume userResumeInfo(HttpServletRequest request){
        Integer userId = (Integer) request.getSession(false).getAttribute("userId");
        QueryWrapper<UserResume> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        UserResume userResume = userResumeMapper.selectOne(wrapper);
        return  userResume;
    }
}
