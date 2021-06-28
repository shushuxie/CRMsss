package com.xiezhuang.menu.controller;

import com.xiezhuang.menu.domain.Menus;
import com.xiezhuang.menu.service.MenuService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * TODO
 *
 * @author 谢树树
 * @date 18/4/2021 下午10:24
 */
@Controller
public class MenusController {

    @Resource
    private MenuService menuService;

    @RequestMapping(value = "queryAll")
    @ResponseBody
    public List<Menus> getAllMenus() {
        List<Menus> list = menuService.selectAllMenus();
        return list;
    }

    @RequestMapping("addMenu")
    public void addMenu(Menus menus,HttpServletRequest request) {
        System.out.println("运行到controller");
        menuService.addMenus(menus,request);
    }

    @RequestMapping("uploadImg")
    public String addMenu2(@Param("picture") MultipartFile picture) throws FileUploadException, IOException {
        System.out.println("运行到controller2");
        byte[] bytes = picture.getBytes();
        Menus menus = new Menus();
        menus.setPicture(bytes);
        menuService.upLoadImg(menus);
        return "fileUploadOK";
    }
    @RequestMapping("fileUpload")
    public String fileUpload(HttpServletRequest request,MultipartFile upload) throws IOException {
        //文件的上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"-"+filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));

        return "fileUploadOK";
        }

    @RequestMapping("showImg")
    public void showImag(@Param("picture") String picture){
        menuService.getImg(picture);

    }
}
