package com.xiezhuang.menu.dao;

import com.xiezhuang.menu.domain.Menus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * TODO
 *
 * @author 谢树树
 * @date 18/4/2021 下午9:31
 */
public interface MenusDao {
    List<Menus> selectAllMenus();
    Integer addMenus(Menus menus);
    void upLoadImg(Menus menus);
    byte[] getImg(String picture);
    Integer deleteMenus();
    void updateMenus();
}
