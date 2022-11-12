package com.hxy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxy.entity.Company;
import com.hxy.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyMapper companyMapper;

    //添加公司信息 存在跟新不存在创建
    @PostMapping("/update")
    @ResponseBody
    public Boolean updateCompany(Company company, HttpServletRequest request){
        Integer userId = (Integer) request.getSession(false).getAttribute("userId");
        QueryWrapper<Company> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        Company company1 = companyMapper.selectOne(wrapper);
        if (company1 != null){
            //更新
            company.setCompanyId(company1.getCompanyId());
            companyMapper.updateById(company);
        }else {
            //创建
            company.setUserId(userId);
            companyMapper.insert(company);
        }
        return true;

    }

    //获取用户公司信息
    @GetMapping("/info")
    @ResponseBody
    public Company companyInfo(HttpServletRequest request){
        Integer userId = (Integer) request.getSession(false).getAttribute("userId");
        QueryWrapper<Company> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        Company company1 = companyMapper.selectOne(wrapper);
        return company1 == null ? null:company1;
    }

}
