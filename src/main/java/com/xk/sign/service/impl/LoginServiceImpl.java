package com.xk.sign.service.impl;

import com.xk.sign.bean.Menu;
import com.xk.sign.bean.Root;
import com.xk.sign.mapper.MenuMapper;
import com.xk.sign.mapper.RootMapper;
import com.xk.sign.mapper.SubMenuMapper;
import com.xk.sign.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

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
            List<Menu> menus = menuMapper.getMenus(root.getId());
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

}
