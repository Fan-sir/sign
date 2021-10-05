package com.xk.sign.service.impl;

import com.xk.sign.bean.SignTime;
import com.xk.sign.bean.User;
import com.xk.sign.bean.UserInfo;
import com.xk.sign.mapper.SignTimeMapper;
import com.xk.sign.mapper.UserMapper;
import com.xk.sign.service.UserService;
import com.xk.sign.token.TokenService;
import com.xk.sign.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Time;
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

    @Resource(name = "tokenService")
    private TokenService tokenService;

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

    @Override
    public HashMap<String, Object> editUser(UserInfo userInfo) {
        String flag = "ok";
        HashMap<String, Object> map = new HashMap<>();
        userMapper.editUser(userInfo);
        map.put("flag", flag);

        return map;
    }

    @Override
    public HashMap<String, Object> login(Integer userNo, String password) {
        HashMap<String, Object> map = new HashMap<>();
        String flag = "error";
        User user = userMapper.login(userNo, password);
        if (user != null) {
            UserInfo userInfo = userMapper.getUserInfoByMessage(user.getId());
            flag = "ok";
            String token = tokenService.getToken(user);
            map.put("userInfo", userInfo);
            map.put("token", token);
        }
        map.put("flag", flag);

        return map;
    }

    @Override
    public HashMap<String, Object> queryUserSignInfoById(Integer userId) {

        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map1 = new HashMap<>();
        Integer weekly = timeUtil.getWeek();
        String dayOfWeekEng = TimeUtil.getDayOfWeekEng();
        map1.put("userId", userId);
        map1.put("weekly", weekly);
        map1.put("dayOfWeekEng", dayOfWeekEng);

        Float dayOfWeekEngInfo = signTimeMapper.queryUserSignInfoById(map1);
        Float timeWeekTotal = signTimeMapper.getTotalTime(userId);

        map.put("dayOfWeekEngInfo", dayOfWeekEngInfo);
        map.put("timeWeekTotal", timeWeekTotal);
        return map;
    }


}
