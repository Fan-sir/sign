package com.xk.sign.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class RootInfo {

    @Schema(name = "id", description = "Id", example = "1")
    private Integer id;

    @Schema(name = "realName", description = "姓名", example = "张三")
    private String realName;

    @Schema(name = "phone", description = "电话号", example = "13344445555")
    private String phone;

    @Schema(name = "qq", description = "QQ", example = "123456789")
    private String qq;

    @Schema(name = "wechat", description = "微信", example = "13344445555")
    private String wechat;

    @Schema(name = "root", description = "用户")
    private Root root;

}
