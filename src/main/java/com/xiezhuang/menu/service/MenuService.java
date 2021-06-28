package com.xiezhuang.menu.service;

import com.xiezhuang.menu.domain.Menus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * TODO
 *
 * @author 谢树树
 * @date 18/4/2021 下午10:09
 */
public interface MenuService {
    List<Menus> selectAllMenus();
    Integer addMenus(Menus menus, HttpServletRequest request);
    void upLoadImg(Menus menus);
    byte[] getImg(String picture);
    Integer deleteMenus();
    void updateMenus();
}
