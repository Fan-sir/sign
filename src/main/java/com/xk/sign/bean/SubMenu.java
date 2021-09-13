package com.xk.sign.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class SubMenu {

    @Schema(name = "id", description = "Id", example = "1")
    private Integer id;

    @Schema(name = "subName", description = "分支菜单名", example = "signIn")
    private String subName;

    @Schema(name = "url", description = "url", example = "/sign")
    private String url;

    @Schema(name = "icon", description = "图标名", example = "block")
    private String icon;

    @Schema(name = "color", description = "颜色", example = "red")
    private String color;


}
