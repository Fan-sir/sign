package com.xk.sign.service.impl;

import com.xk.sign.bean.SignTime;
import com.xk.sign.mapper.SignTimeMapper;
import com.xk.sign.service.SignTimeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Transactional
@Service("signTimeService")
public class SignTimeServiceImpl implements SignTimeService {

    @Resource(name = "signTimeMapper")
    private SignTimeMapper signTimeMapper;

    @Override
    public HashMap<String, Object> getTimeData() {
        HashMap<String, Object> map = new HashMap<>();
        float timeWeekTotal;
        List<SignTime> signTimeList = signTimeMapper.findTimeData();

        for (SignTime signTime : signTimeList) {
            timeWeekTotal = signTime.getMonday() + signTime.getTuesday() + signTime.getWednesday() + signTime.getThursday() + signTime.getFriday() + signTime.getSaturday() + signTime.getSunday();
            signTime.setTimeWeekTotal(timeWeekTotal);
            timeWeekTotal = 0.00f;
        }
        map.put("tableData", signTimeList);
        return map;
    }

    @Override
    public HashMap<String, Object> delSignTimeIds(List<Integer> list) {
        String flag = "ok";
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(list);
        for (Integer i : list) {
            signTimeMapper.delSignTimeIds(i);
        }
        map.put("flag", flag);
        System.out.println(flag);
        return map;
    }
}
