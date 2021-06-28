package com.xiezhuang.menu.service.impl;/**
 * TODO
 *
 * @author 谢树树
 * @date 18/4/2021 下午10:10
 */

import com.xiezhuang.menu.dao.MenusDao;
import com.xiezhuang.menu.domain.Menus;
import com.xiezhuang.menu.service.MenuService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 *18/4/2021 下午10:10
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenusDao menusDao;

    @Override
    public List<Menus> selectAllMenus() {
        ArrayList list = (ArrayList) menusDao.selectAllMenus();
        return list;
    }

    @Override
    public Integer addMenus(Menus menus, HttpServletRequest request) {
        System.out.println("运行到service--addMenus");
        menusDao.addMenus(menus);
       return null;
    }

    @Override
    public void upLoadImg(Menus menus){
        System.out.println("运行到service--upLoadImg");
//        menusDao.upLoadImg(bytes);
            menusDao.upLoadImg(menus);
    }

    @Override
    public byte[] getImg(String picture) {
       return null;
    }

    @Override
    public Integer deleteMenus() {
        return null;
    }

    @Override
    public void updateMenus() {

    }
}
