package com.hxy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxy.entity.Success;
import com.hxy.entity.UserComPosition;
import com.hxy.mapper.SuccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hxy
 * @since 2022-09-15
 */
@Controller
@RequestMapping("/success")
public class SuccessController {
    @Autowired
    private SuccessMapper successMapper;
    //所有用户收到的简历
    @GetMapping("/userAllSuccess")
    @ResponseBody
    public List<UserComPosition> userAllSucess(HttpServletRequest request){
        Integer userId = (Integer) request.getSession(false).getAttribute("userId");
        List<UserComPosition> userAllSuccess = successMapper.getUserAllSuccess(userId);
        return userAllSuccess;
    }

    //删除入职通知
    @DeleteMapping("/delSuccess/{successId}")
    @ResponseBody
    public Boolean delSuccess(@PathVariable("successId") Integer successId){
        int i = successMapper.deleteById(successId);
        return i != -1 ? true:false;
    }

    //添加入职通知
    @PostMapping("/add")
    @ResponseBody
    public Boolean addSuccess(Success success){
        int i = successMapper.insert(success);
        return i != -1 ? true:false;
    }

}
