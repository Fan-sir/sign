package com.xk.sign.controller;

import com.alibaba.fastjson.JSON;
import com.xk.sign.bean.Root;
import com.xk.sign.bean.RootInfo;
import com.xk.sign.service.RootService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class RootController {

    @Resource(name = "rootService")
    private RootService rootService;

    @RequestMapping("/login")
    public String login(@RequestBody Root root) {
        HashMap<String, Object> map = rootService.login(root.getUsername(), root.getPassword());
        return JSON.toJSONString(map);
    }

    @RequestMapping("/admin")
    public String getRootList() {
        HashMap<String, Object> map = rootService.getRootList();
        return JSON.toJSONString(map);
    }

    @RequestMapping("/addRoot")
    public String addRoot(@RequestBody RootInfo rootInfo) {
        HashMap<String, Object> map = rootService.addRoot(rootInfo);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/delRootByRootId")
    public String delRootByRootId(@RequestBody List<Integer> list) {
        HashMap<String, Object> map = rootService.delRootByRootId(list);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/editRoot")
    public String editRoot(@RequestBody RootInfo rootInfo) {
        HashMap<String, Object> map = rootService.editRoot(rootInfo);
        return JSON.toJSONString(map);
    }

}
