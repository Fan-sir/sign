package com.xk.sign.controller;

import com.alibaba.fastjson.JSON;
import com.xk.sign.bean.Root;
import com.xk.sign.bean.RootInfo;
import com.xk.sign.service.RootService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Tag(name = "root-controller", description = "管理员类接口")
@RestController
public class RootController {

    @Resource(name = "rootService")
    private RootService rootService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public String login(@RequestBody Root root) {
        HashMap<String, Object> map = rootService.login(root.getUsername(), root.getPassword());
        return JSON.toJSONString(map);
    }

    @ApiOperation("获取管理员列表")
    @GetMapping("/admin")
    public String getRootList() {
        HashMap<String, Object> map = rootService.getRootList();
        return JSON.toJSONString(map);
    }

    @ApiOperation("增加管理员")
    @PostMapping("/addRoot")
    public String addRoot(@RequestBody RootInfo rootInfo) {
        HashMap<String, Object> map = rootService.addRoot(rootInfo);
        return JSON.toJSONString(map);
    }

    @ApiOperation("通过RootId删除Root")
    @DeleteMapping("/delRootByRootId")
    public String delRootByRootId(@RequestBody List<Integer> list) {
        HashMap<String, Object> map = rootService.delRootByRootId(list);
        return JSON.toJSONString(map);
    }

    @ApiOperation("修改Root")
    @PutMapping("/editRoot")
    public String editRoot(@RequestBody RootInfo rootInfo) {
        HashMap<String, Object> map = rootService.editRoot(rootInfo);
        return JSON.toJSONString(map);
    }

}
