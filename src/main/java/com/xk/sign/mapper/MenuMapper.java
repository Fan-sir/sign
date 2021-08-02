package com.xk.sign.mapper;

import com.xk.sign.bean.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuMapper")
public interface MenuMapper {
    List<Menu> getMenus(Integer roleId);

}
