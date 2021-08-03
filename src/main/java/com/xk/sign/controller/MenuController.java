package com.xk.sign.controller;

import com.alibaba.fastjson.JSON;
import com.xk.sign.bean.User;
import com.xk.sign.service.MenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class MenuController {

    @Resource(name = "menuService")
    private MenuService menuService;

    @RequestMapping("/signIn")
    public String signIn(User user) {
        System.out.println(user);
        HashMap<String, String> map = menuService.signIn(user.getUserNo());
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }

    @RequestMapping("/signOut")
    public String signOut(User user) {
        HashMap<String, String> map = menuService.signOut(user.getUserNo());
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }

}
