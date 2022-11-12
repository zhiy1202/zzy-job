package com.hxy.service.impl;

import com.hxy.entity.Company;
import com.hxy.mapper.CompanyMapper;
import com.hxy.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hxy
 * @since 2022-09-15
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

}
