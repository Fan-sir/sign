package com.xk.sign.service;

import com.xk.sign.bean.SignTime;
import com.xk.sign.bean.UserInfo;
import java.util.HashMap;
import java.util.List;

public interface UserService {
    HashMap<String, List<UserInfo>> getUserList();

    HashMap<String, Object> delUserByUserId(List<Integer> list);

    HashMap<String, Object> addUser(UserInfo userInfo);

    HashMap<String, Object> editUser(UserInfo userInfo);

    HashMap<String, Object> login(Integer userNo, String password);

    HashMap<String, Object> queryUserSignInfoById(Integer userId);
}
