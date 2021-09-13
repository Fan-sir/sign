package com.xk.sign.mapper;

import com.xk.sign.bean.User;
import com.xk.sign.bean.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper {

    User find(Integer userNo);

    List<UserInfo> getUserList();

    void delUserByUserId(Integer i);

    void addUser(UserInfo userInfo);

    void addUserInfo(UserInfo userInfo);

    void editUser(UserInfo userInfo);

    User login(Integer userNo, String password);

    UserInfo getUserInfoByMessage(int userId);

    User getUserById(int userId);
}
