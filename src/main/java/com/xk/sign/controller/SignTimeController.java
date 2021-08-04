package com.xk.sign.controller;

import com.alibaba.fastjson.JSON;
import com.xk.sign.service.SignTimeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class SignTimeController {

    @Resource(name = "signTimeService")
    private SignTimeService signTimeService;

    @RequestMapping("/time")
    public String time() {
        HashMap<String, Object> map = signTimeService.getTimeData();
        return JSON.toJSONString(map);
    }

    @RequestMapping("/delSignTimeInfo")
    public String delSignTimeInfo(@RequestBody List<Integer> list) {
        HashMap<String, Object> map = signTimeService.delSignTimeIds(list);
        return JSON.toJSONString(map);
    }

}
