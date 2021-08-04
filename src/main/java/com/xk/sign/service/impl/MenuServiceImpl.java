package com.xk.sign.service.impl;

import com.xk.sign.bean.SignTime;
import com.xk.sign.bean.User;
import com.xk.sign.mapper.SignTimeMapper;
import com.xk.sign.mapper.UserMapper;
import com.xk.sign.service.MenuService;
import com.xk.sign.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

@Transactional
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Resource(name = "signTimeMapper")
    private SignTimeMapper signTimeMapper;

    @Resource(name = "timeUtil")
    private TimeUtil timeUtil;

    @Override
    public HashMap<String, String> signIn(Integer userNo) {

        String flag;
        User user = userMapper.find(userNo);
        HashMap<String, String> mapFlag = new HashMap<>();
        if (null == user) {
            flag = "error";
            mapFlag.put("flag", flag);
            return mapFlag;
        }
        SignTime signTime = signTimeMapper.findIndexTime(user.getId());
        if (signTime.getIndexTime() != null) {
            flag = "repeat";
            mapFlag.put("flag", flag);
            return mapFlag;
        }
        long time = new Date().getTime();
        HashMap<String, Object> map = new HashMap<>();
        map.put("indexTime", time);
        map.put("userId", user.getId());
        signTimeMapper.addIndexTime(map);
        flag = "ok";
        mapFlag.put("flag", flag);

        return mapFlag;
    }

    @Override
    public HashMap<String, String> signOut(Integer userNo) {
        String flag;
        User user = userMapper.find(userNo);
        HashMap<String, String> mapFlag = new HashMap<>();
        if (null == user){
            flag = "error";
            mapFlag.put("flag", flag);
            return mapFlag;
        }
        SignTime signTime = signTimeMapper.findIndexTime(user.getId());
        if (signTime.getIndexTime() == null) {
            flag = "repeat";
            mapFlag.put("flag", flag);
            return mapFlag;
        }
        float time1 = TimeUtil.time(signTime.getIndexTime());
        HashMap<String, Object> map = new HashMap<>();
        String week = TimeUtil.getDayOfWeekEng();
        Integer weekly = timeUtil.getWeek();
        map.put("week", week);
        map.put("userId", user.getId());
        map.put("time", time1);
        map.put("weekly", weekly);
        signTimeMapper.addTime(map);
        signTimeMapper.deleteIndexTime(map);
        flag = "ok";
        mapFlag.put("flag", flag);
        return mapFlag;
    }

}
