package com.xk.sign.controller;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
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
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@Tag(name = "menu-controller", description = "菜单类接口")
@RequestMapping("menu")
public class MenuController {

    @Resource(name = "menuService")
    private MenuService menuService;

    @ApiOperation("签到接口")
    @GetMapping("/signIn")
    public String signIn(User user, HttpServletRequest request) {
        String clientId = request.getHeader("clientId");
        if (clientId != null){
            if (clientId.equals("6510e571769e8c321df17a6f83ee4303")) {//手机客户端Id
                String token = request.getHeader("token");
                long indexTime = Long.parseLong(JWT.decode(token).getAudience().get(1));
                if ((indexTime - System.currentTimeMillis()) < 0) {
                    throw new RuntimeException("二维码已失效!");
                }
                System.out.println(user);
                HashMap<String, String> map = menuService.signIn(user.getUserNo());
                System.out.println(JSON.toJSONString(map));
                return JSON.toJSONString(map);
            }
            if (clientId.equals("f8880cb4b31f7a32011bd008f9bb6b10")){
                System.out.println(user);
                HashMap<String, String> map = menuService.signIn(user.getUserNo());
                System.out.println(JSON.toJSONString(map));
                return JSON.toJSONString(map);
            }

            throw new RuntimeException("未知的客户端Id");
        }
        throw new RuntimeException("客户端Id为null");
    }

    @GetMapping("/signOut")
    @ApiOperation("签退接口")
    public String signOut(User user) {
        HashMap<String, String> map = menuService.signOut(user.getUserNo());
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }

}
