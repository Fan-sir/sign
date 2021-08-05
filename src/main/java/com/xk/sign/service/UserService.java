package com.xk.sign.service;

import com.xk.sign.bean.UserInfo;
import java.util.HashMap;
import java.util.List;

public interface UserService {
    HashMap<String, List<UserInfo>> getUserList();

    HashMap<String, Object> delUserByUserId(List<Integer> list);

    HashMap<String, Object> addUser(UserInfo userInfo);
}
