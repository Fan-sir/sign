package com.xk.sign.controller;

import com.alibaba.fastjson.JSON;
import com.xk.sign.bean.User;
import com.xk.sign.service.MenuService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@Tag(name = "menu-controller", description = "菜单类接口")
public class MenuController {

    @Resource(name = "menuService")
    private MenuService menuService;

    @ApiOperation("签到接口")
    @GetMapping("/signIn")
    public String signIn(User user) {
        System.out.println(user);
        HashMap<String, String> map = menuService.signIn(user.getUserNo());
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }

    @GetMapping("/signOut")
    @ApiOperation("签退接口")
    public String signOut(User user) {
        HashMap<String, String> map = menuService.signOut(user.getUserNo());
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }

}
