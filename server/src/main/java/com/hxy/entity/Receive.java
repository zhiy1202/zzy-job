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
@TableName("t_receive")
public class Receive implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "receive_id", type = IdType.AUTO)
    private Integer receiveId;

    private Integer companyId;

    private Integer positionId;

    private Integer userId;

    private Integer resumeId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
