package com.xk.sign.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class User {

    @Schema(name = "id", description = "Id", example = "1")
    private Integer id;

    @Schema(name = "userNo", description = "学号", example = "2020210230")
    private Integer userNo;

    @Schema(name = "password", description = "密码", example = "123456")
    private String password;

    @Schema(name = "role", description = "角色")
    private Role role;

}
