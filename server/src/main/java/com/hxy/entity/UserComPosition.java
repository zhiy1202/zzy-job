package com.hxy.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zzy
 * @desc 公司用户职位共同类
 */
@Data
public class UserComPosition {
    private Integer companyId;
    private String comName;
    private String comIntro;
    private String comAddress;
    private String comTelephone;

    private Integer userId;
    private String username;

    private Integer positionId;
    private String title;
    private Double money;
    private String intro;
    private LocalDateTime createTime;

    private Integer receiveId;
    private Integer successId;

    private Integer resumeId;
    private Double wage;
    private String telephone;
    private String address;
    private String email;
    private String content;
}
