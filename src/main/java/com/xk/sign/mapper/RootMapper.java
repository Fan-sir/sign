package com.xk.sign.mapper;

import com.xk.sign.bean.Root;
import org.springframework.stereotype.Repository;

@Repository("rootMapper")
public interface RootMapper {

    Root getRootByMessage(String username, String password);
}
