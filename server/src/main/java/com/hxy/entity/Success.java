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
@TableName("t_success")
public class Success implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "success_id", type = IdType.AUTO)
    private Integer successId;

    private Integer userId;

    private Integer companyId;

    private Integer positionId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
