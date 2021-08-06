package com.xk.sign.service;

import com.xk.sign.bean.RootInfo;

import java.util.HashMap;
import java.util.List;

public interface RootService {
    HashMap<String, Object> login(String username, String password);

    HashMap<String, Object> getRootList();

    HashMap<String, Object> addRoot(RootInfo rootInfo);

    HashMap<String, Object> delRootByRootId(List<Integer> list);

    HashMap<String, Object> editRoot(RootInfo rootInfo);
}
