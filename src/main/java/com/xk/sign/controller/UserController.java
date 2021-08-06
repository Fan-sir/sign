package com.xk.sign.controller;

import com.alibaba.fastjson.JSON;
import com.xk.sign.bean.UserInfo;
import com.xk.sign.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/user")
    public String user() {
        HashMap<String, List<UserInfo>> map = userService.getUserList();
        return JSON.toJSONString(map);
    }

    @RequestMapping("/delUserByUserId")
    public String delUserByUserId(@RequestBody List<Integer> list) {
        HashMap<String, Object> map = userService.delUserByUserId(list);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo) {
        HashMap<String, Object> map = userService.addUser(userInfo);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody UserInfo userInfo) {
        HashMap<String, Object> map = userService.editUser(userInfo);
        return JSON.toJSONString(map);
    }

}
