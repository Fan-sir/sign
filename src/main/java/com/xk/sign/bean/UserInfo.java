package com.xk.sign.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class UserInfo {

    @Schema(name = "id", description = "Id", example = "1")
    private Integer id;

    @Schema(name = "realName", description = "姓名", example = "张三")
    private String realName;

    @Schema(name = "classes", description = "班级", example = "软件2002")
    private String classes;

    @Schema(name = "phone", description = "电话号", example = "13344445555")
    private String phone;

    @Schema(name = "qq", description = "QQ", example = "123456789")
    private String qq;

    @Schema(name = "totalTime", description = "签到总时长", example = "0.0")
    private Float totalTime;

    @Schema(name = "user", description = "用户")
    private User user;

}
