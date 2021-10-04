package com.xk.sign.controller;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.xk.sign.bean.User;
import com.xk.sign.service.MenuService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController///'''/
@Tag(name = "menu-controller", description = "菜单类接口")
@RequestMapping("menu")
public class MenuController {

    @Resource(name = "menuService")
    private MenuService menuService;

    @ApiOperation("获取菜单列表接口")
    @GetMapping("/getMenus")
    public String getMenus(HttpServletRequest request) {
        int rootId = Integer.parseInt(JWT.decode(request.getHeader("token")).getAudience().get(0));
        HashMap<String, Object> map = menuService.getMenus(rootId);
        return JSON.toJSONString(map);
    }

    @ApiOperation("签到接口")
    @GetMapping("/signIn")
    public String signIn(Long expirationTime, Integer userNo, HttpServletRequest request) {
        System.out.println(expirationTime);
        String clientId = request.getHeader("clientId");
        if (clientId != null) {
            if (clientId.equals("6510e571769e8c321df17a6f83ee4303")) {//手机客户端Id
//                long expirationTime = Long.parseLong(request.getHeader("expirationTime"));
                if ((expirationTime - System.currentTimeMillis()) < 0) {
                    throw new RuntimeException("二维码已失效!");
                }
                Integer userNo_ = Integer.parseInt(JWT.decode(request.getHeader("token")).getAudience().get(0));
                HashMap<String, String> map = menuService.signIn(userNo_);
                System.out.println(JSON.toJSONString(map));
                return JSON.toJSONString(map);
            }
            if (clientId.equals("f8880cb4b31f7a32011bd008f9bb6b10")) {
                HashMap<String, String> map = menuService.signIn(userNo);
                System.out.println(JSON.toJSONString(map));
                return JSON.toJSONString(map);
            }

            throw new RuntimeException("未知的客户端Id");
        }
        throw new RuntimeException("客户端Id为null");
    }

    @GetMapping("/signOut")
    @ApiOperation("签退接口")
    public String signOut(Integer userNo, HttpServletRequest request, Long expirationTime) {

        String clientId = request.getHeader("clientId");
        if (clientId != null) {
            if (clientId.equals("6510e571769e8c321df17a6f83ee4303")) {//手机客户端Id
//                long expirationTime = Long.parseLong(request.getHeader("expirationTime"));
                if ((expirationTime - System.currentTimeMillis()) < 0) {
                    throw new RuntimeException("二维码已失效!");
                }
                Integer userNo_ = Integer.parseInt(JWT.decode(request.getHeader("token")).getAudience().get(0));
                HashMap<String, String> map = menuService.signOut(userNo_);
                System.out.println(JSON.toJSONString(map));
                return JSON.toJSONString(map);
            }
            if (clientId.equals("f8880cb4b31f7a32011bd008f9bb6b10")) {
                HashMap<String, String> map = menuService.signOut(userNo);
                System.out.println(JSON.toJSONString(map));
                return JSON.toJSONString(map);
            }

            throw new RuntimeException("未知的客户端Id");
        }
        throw new RuntimeException("客户端Id为null");
    }

}
