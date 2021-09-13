package com.xk.sign.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class Root {
    @Schema(name = "id", description = "Id", example = "1")
    private Integer id;

    @Schema(name = "username", description = "用户名", example = "root")
    private String username;

    @Schema(name = "password", description = "密码", example = "123456")
    private String password;

    @Schema(name = "role", description = "角色")
    private Role role;

}
