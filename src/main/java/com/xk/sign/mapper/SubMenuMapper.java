package com.xk.sign.mapper;

import com.xk.sign.bean.SubMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("subMenuMapper")
public interface SubMenuMapper {
    List<SubMenu> getSubMenus(Integer menuId, Integer roleId);

}
