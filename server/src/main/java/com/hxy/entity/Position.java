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
@TableName("t_position")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "position_id", type = IdType.AUTO)
    private Integer positionId;

    private Integer companyId;

    private String title;

    private Double money;

    private String intro;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
