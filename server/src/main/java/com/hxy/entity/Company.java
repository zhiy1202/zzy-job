package com.hxy.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author hxy
 * @since 2022-09-15
 */
@Getter
@Setter
@TableName("t_company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "company_id", type = IdType.AUTO)
    private Integer companyId;

    private String comName;

    private String comIntro;

    private String comAddress;

    @TableField(fill = FieldFill.INSERT)
    private String comTelephone;
    private Integer userId;


}
