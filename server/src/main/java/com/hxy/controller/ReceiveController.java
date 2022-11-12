package com.hxy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxy.entity.Receive;
import com.hxy.entity.UserComPosition;
import com.hxy.entity.UserResume;
import com.hxy.mapper.ReceiveMapper;
import com.hxy.mapper.UserResumeMapper;
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
@RequestMapping("/receive")
public class ReceiveController {
    @Autowired
    private ReceiveMapper receiveMapper;

    @Autowired
    private UserResumeMapper userResumeMapper;

    //添加
    @PostMapping("/add")
    @ResponseBody
    public Boolean addReceive(Receive receive , HttpServletRequest request){
        Integer userId = (Integer) request.getSession(false).getAttribute("userId");
        //获取用户简历id
        QueryWrapper<UserResume> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        UserResume userResume = userResumeMapper.selectOne(wrapper);
        if (userResume != null){
            receive.setUserId(userId);
            receive.setResumeId(userResume.getResumeId());
            receiveMapper.insert(receive);
            return true;
        }
        return false;
    }

    //通过userId 获取其投递的简历
    @GetMapping("/userReceive")
    @ResponseBody
    public List<UserComPosition> userReceive(HttpServletRequest request){
        Integer userId = (Integer) request.getSession(false).getAttribute("userId");
        List<UserComPosition> allUserReceive = receiveMapper.getAllUserReceive(userId);
        return allUserReceive;
    }

    //通过receiveId 删除
    @DeleteMapping("/delete/{receiveId}")
    @ResponseBody
    public Boolean deleteReceive(@PathVariable("receiveId") Integer receiveId){
        int i = receiveMapper.deleteById(receiveId);
        return i != -1 ? true:false;
    }

    //获得一个公司下的所有投递
    @GetMapping("/companyAllReceive")
    @ResponseBody
    public List<UserComPosition> companyAllReceive(HttpServletRequest request){
        Integer companyId = (Integer) request.getSession(false).getAttribute("companyId");
        List<UserComPosition> allCompanyReceive = receiveMapper.getAllCompanyReceive(companyId);
        return allCompanyReceive;
    }

}
