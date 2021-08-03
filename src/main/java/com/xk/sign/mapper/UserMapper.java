package com.xk.sign.mapper;

import com.xk.sign.bean.User;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper {

    User find(Integer userNo);

}
