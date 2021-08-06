package com.xk.sign.mapper;

import com.xk.sign.bean.Root;
import com.xk.sign.bean.RootInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("rootMapper")
public interface RootMapper {

    Root getRootByMessage(String username, String password);

    List<RootInfo> getRootList();

    void addRoot(RootInfo rootInfo);

    void addRootInfo(RootInfo rootInfo);

    void delRootByRootId(Integer i);

    void editRoot(RootInfo rootInfo);
}
