package com.hxy.controller;

import com.hxy.entity.Position;
import com.hxy.entity.UserComPosition;
import com.hxy.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionMapper positionMapper;
    //得到所有工作
    @GetMapping("/all")
    @ResponseBody
    public List<UserComPosition> getAllPosition(){
        return positionMapper.getAllPosition();
    }

    //通过title模糊查询
    @GetMapping("/searchTitle/{title}")
    @ResponseBody
    public List<UserComPosition> searchTitle(@PathVariable("title") String title){
        List<UserComPosition> positionsByTitle = positionMapper.getPositionsByTitle(title);
        return positionsByTitle;
    }

    //进入职位详情页面
    @GetMapping("/detail/{positionId}")
    public String jobDetail(@PathVariable("positionId") Integer positionId , Model model){
        UserComPosition positionDetail = positionMapper.getPositionDetail(positionId);
        model.addAttribute("positionDetail",positionDetail);
        return "user/jobDetails";
    }

    //获取一个公司所有的职位
    @GetMapping("/company")
    @ResponseBody
    public List<UserComPosition> companyAllPosition(HttpServletRequest request){
        Integer userId = (Integer) request.getSession(false).getAttribute("userId");

        List<UserComPosition> companyAllPosition = positionMapper.getCompanyAllPosition(userId);
        return companyAllPosition;

    }

    //通过id删除职位
    @DeleteMapping("/delPosition/{positionId}")
    @ResponseBody
    public Boolean delPosition(@PathVariable("positionId") Integer positionId){
        int i = positionMapper.deleteById(positionId);
        return i != -1 ? true: false;
    }

    //添加职位
    @PostMapping("/add")
    @ResponseBody
    public Boolean addPosition(Position position , HttpServletRequest request){
        Integer companyId = (Integer) request.getSession(false).getAttribute("companyId");
        position.setCompanyId(companyId);
        int i = positionMapper.insert(position);
        return i != -1 ? true: false;
    }
}
