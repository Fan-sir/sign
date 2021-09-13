package com.xk.sign.controller;

import com.alibaba.fastjson.JSON;
import com.xk.sign.service.SignTimeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "sign-time-controller", description = "签到时长类接口")
public class SignTimeController {

    @Resource(name = "signTimeService")
    private SignTimeService signTimeService;

    @ApiOperation("查看所有人时长接口")
    @GetMapping("/time")
    public String time() {
        HashMap<String, Object> map = signTimeService.getTimeData();
        return JSON.toJSONString(map);
    }

    @ApiOperation("删除签到信息接口")
    @DeleteMapping("/delSignTimeInfo")
    public String delSignTimeInfo(@RequestBody List<Integer> list) {
        HashMap<String, Object> map = signTimeService.delSignTimeIds(list);
        return JSON.toJSONString(map);
    }

}
