package com.xk.sign.service.impl;

import com.xk.sign.bean.Menu;
import com.xk.sign.bean.Root;
import com.xk.sign.bean.RootInfo;
import com.xk.sign.mapper.MenuMapper;
import com.xk.sign.mapper.RootMapper;
import com.xk.sign.mapper.SubMenuMapper;
import com.xk.sign.service.RootService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Transactional
@Service("rootService")
public class RootServiceImpl implements RootService {

    @Resource(name = "rootMapper")
    private RootMapper rootMapper;

    @Resource(name = "menuMapper")
    private MenuMapper menuMapper;

    @Resource(name = "subMenuMapper")
    private SubMenuMapper subMenuMapper;

    @Override
    public HashMap<String, Object> login(String username, String password) {
        HashMap<String, Object> map = new HashMap<>();
        String flag = "error";
        Root root = rootMapper.getRootByMessage(username, password);
        if (root != null) {
            List<Menu> menus = menuMapper.getMenus(root.getRole().getId());
            if (null != menus) {
                for (Menu menu : menus) {
                    menu.setSubMenuList(subMenuMapper.getSubMenus(menu.getMenuId(), menu.getRole().getId()));
                }
                map.put("menus", menus);
            }
            flag = "ok";
            map.put("root", root);
        }
        map.put("flag", flag);

        return map;
    }

    @Override
    public HashMap<String, Object> getRootList() {
        HashMap<String, Object> map = new HashMap<>();
        List<RootInfo> rootInfoList = rootMapper.getRootList();
        map.put("rootList", rootInfoList);
        return map;
    }

    @Override
    public HashMap<String, Object> addRoot(RootInfo rootInfo) {
        String flag = "ok";
        HashMap<String, Object> map = new HashMap<>();
        rootMapper.addRoot(rootInfo);
        rootMapper.addRootInfo(rootInfo);
        map.put("flag", flag);
        return map;
    }

    @Override
    public HashMap<String, Object> delRootByRootId(List<Integer> list) {
        String flag = "ok";
        HashMap<String, Object> map = new HashMap<>();
        for (Integer i : list) {
            rootMapper.delRootByRootId(i);
        }
        map.put("flag", flag);

        return map;
    }

    @Override
    public HashMap<String, Object> editRoot(RootInfo rootInfo) {
        String flag = "ok";
        HashMap<String, Object> map = new HashMap<>();
        rootMapper.editRoot(rootInfo);
        map.put("flag", flag);

        return map;
    }

}
