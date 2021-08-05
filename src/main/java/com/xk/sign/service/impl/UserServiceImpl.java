package com.xk.sign.service.impl;

import com.xk.sign.bean.UserInfo;
import com.xk.sign.mapper.SignTimeMapper;
import com.xk.sign.mapper.UserMapper;
import com.xk.sign.service.UserService;
import com.xk.sign.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Resource(name = "signTimeMapper")
    private SignTimeMapper signTimeMapper;

    @Resource(name = "timeUtil")
    private TimeUtil timeUtil;

    @Override
    public HashMap<String, List<UserInfo>> getUserList() {
        HashMap<String, List<UserInfo>> map = new HashMap<>();
        List<UserInfo> userInfoList = userMapper.getUserList();
        for (UserInfo u : userInfoList) {
            u.setTotalTime(signTimeMapper.getTotalTime(u.getUser().getId()));
        }
        map.put("userList", userInfoList);
        return map;
    }

    @Override
    public HashMap<String, Object> delUserByUserId(List<Integer> list) {

        String flag = "ok";
        HashMap<String, Object> map = new HashMap<>();
        for (Integer i : list) {
            userMapper.delUserByUserId(i);
        }
        map.put("flag", flag);

        return map;
    }

    @Override
    public HashMap<String, Object> addUser(UserInfo userInfo) {
        String flag = "ok";
        Integer weekly = timeUtil.getWeek();
        HashMap<String, Object> map = new HashMap<>();
        userMapper.addUser(userInfo);
        userMapper.addUserInfo(userInfo);
        signTimeMapper.createSignTimeByUserId(weekly, userInfo.getUser().getId());
        map.put("flag", flag);
        return map;
    }
}
