package com.xk.sign.controller;

import com.alibaba.fastjson.JSON;
import com.xk.sign.bean.Root;
import com.xk.sign.service.LoginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class RootController {

    @Resource(name = "loginService")
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(@RequestBody Root root) {
        HashMap<String, Object> map = loginService.login(root.getUsername(), root.getPassword());
        return JSON.toJSONString(map);
    }

}
