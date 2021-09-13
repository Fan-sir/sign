package com.xk.sign.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class Role {

    @Schema(name = "id", description = "Id", example = "1")
    private Integer id;

    @Schema(name = "roleName", description = "角色名", example = "管理员")
    private String roleName;

}
