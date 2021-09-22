package com.xk.sign.service.impl;

import com.auth0.jwt.JWT;
import com.xk.sign.bean.Menu;
import com.xk.sign.bean.Root;
import com.xk.sign.bean.SignTime;
import com.xk.sign.bean.User;
import com.xk.sign.mapper.MenuMapper;
import com.xk.sign.mapper.SignTimeMapper;
import com.xk.sign.mapper.SubMenuMapper;
import com.xk.sign.mapper.UserMapper;
import com.xk.sign.service.MenuService;
import com.xk.sign.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Transactional
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Resource(name = "signTimeMapper")
    private SignTimeMapper signTimeMapper;

    @Resource(name = "timeUtil")
    private TimeUtil timeUtil;

    @Resource(name = "menuMapper")
    private MenuMapper menuMapper;

    @Resource(name = "subMenuMapper")
    private SubMenuMapper subMenuMapper;

    @Override
    public HashMap<String, String> signIn(Integer userNo) {

        String flag;
        User user = userMapper.find(userNo);
        HashMap<String, String> mapFlag = new HashMap<>();
        if (null == user) {
            flag = "error";
            mapFlag.put("flag", flag);
            return mapFlag;
        }
        Integer weekly = timeUtil.getWeek();
        SignTime signTime = signTimeMapper.findIndexTime(user.getId(), weekly);
        if (signTime.getIndexTime() != null) {
            flag = "repeat";
            mapFlag.put("flag", flag);
            return mapFlag;
        }
        long time = new Date().getTime();
        HashMap<String, Object> map = new HashMap<>();
        map.put("indexTime", time);
        map.put("userId", user.getId());
        signTimeMapper.addIndexTime(map);
        flag = "ok";
        mapFlag.put("flag", flag);

        return mapFlag;
    }

    @Override
    public HashMap<String, String> signOut(Integer userNo) {
        String flag;
        User user = userMapper.find(userNo);
        HashMap<String, String> mapFlag = new HashMap<>();
        if (null == user) {
            flag = "error";
            mapFlag.put("flag", flag);
            return mapFlag;
        }
        Integer weekly = timeUtil.getWeek();
        SignTime signTime = signTimeMapper.findIndexTime(user.getId(), weekly);
        if (signTime.getIndexTime() == null) {
            flag = "repeat";
            mapFlag.put("flag", flag);
            return mapFlag;
        }
        float time1 = TimeUtil.time(signTime.getIndexTime());
        HashMap<String, Object> map = new HashMap<>();
        String week = TimeUtil.getDayOfWeekEng();
        map.put("week", week);
        map.put("userId", user.getId());
        map.put("time", time1);
        map.put("weekly", weekly);
        signTimeMapper.addTime(map);
        signTimeMapper.deleteIndexTime(map);
        flag = "ok";
        mapFlag.put("flag", flag);
        return mapFlag;
    }

    @Override
    public HashMap<String, Object> getMenus(Integer rootId) {
        HashMap<String, Object> map = new HashMap<>();
        String flag = "error";
        List<Menu> menus = menuMapper.getMenus(rootId);
        if (null != menus) {
            for (Menu menu : menus) {
                menu.setSubMenuList(subMenuMapper.getSubMenus(menu.getMenuId(), menu.getRole().getId()));
            }
            flag = "ok";
            map.put("menus", menus);
            map.put("flag", flag);
        }

        return map;
    }

}
