package com.xk.sign.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xk.sign.bean.User;
import com.xk.sign.bean.UserInfo;
import com.xk.sign.service.UserService;
import com.xk.sign.token.LoginToken;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Tag(name = "user-controller", description = "用户类接口")
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public String login(@RequestBody User user){
        HashMap<String, Object> map = userService.login(user.getUserNo(), user.getPassword());
        return JSON.toJSONString(map);
    }


    @ApiOperation("获取用户列表")
    @GetMapping("/user")
    @LoginToken
    public String user() {
        HashMap<String, List<UserInfo>> map = userService.getUserList();
        return JSONObject.toJSONString(map);
    }

    @ApiOperation("通过UserId删除User")
    @DeleteMapping("/delUserByUserId")
    public String delUserByUserId(@RequestBody List<Integer> list) {
        HashMap<String, Object> map = userService.delUserByUserId(list);
        return JSON.toJSONString(map);
    }

    @ApiOperation("增加User")
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo) {
        HashMap<String, Object> map = userService.addUser(userInfo);
        return JSON.toJSONString(map);
    }

    @ApiOperation("编辑User信息")
    @PutMapping("/editUser")
    public String editUser(@RequestBody UserInfo userInfo) {
        HashMap<String, Object> map = userService.editUser(userInfo);
        return JSON.toJSONString(map);
    }

}
