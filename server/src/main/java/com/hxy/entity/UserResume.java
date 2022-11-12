package com.hxy.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("user_resume")
public class UserResume implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "resume_id", type = IdType.AUTO)
    private Integer resumeId;

    private Integer userId;

    private String telephone;

    private String address;

    private Double wage;

    private String email;

    private String intro;

    private String content;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
