package com.xk.sign.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema
@Data
public class Menu {

    @Schema(name = "id", description = "Id", example = "1")
    private Integer id;

    @Schema(name = "title", description = "主菜单名", example = "sign")
    private String title;

    @Schema(name = "url", description = "url", example = "/sign")
    private String url;

    @Schema(name = "icon", description = "图标名", example = "block")
    private String icon;

    @Schema(name = "color", description = "颜色", example = "red")
    private String color;

    @Schema(name = "menuId", description = "第几个菜单", example = "1")
    private Integer menuId;

    @Schema(name = "role", description = "角色")
    private Role role;

    @Schema(name = "subMenuList", description = "分支菜单")
    private List<SubMenu> subMenuList;

}
