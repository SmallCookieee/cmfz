package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Shuffling;
import com.baizhi.cmfz.service.ShufflingService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by zxl on 2018/7/5.
 */
@Controller
@RequestMapping("/shuffling")
public class ShufflingController {
    @Autowired
    private ShufflingService ss;
    @RequestMapping("/showAllPic")
    @ResponseBody
    public Map<String, Object> showAllPic(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        return ss.queryAllPic(page, rows);
    }
    @RequestMapping("/insertPic")
    @ResponseBody
    public Shuffling insertPic(MultipartFile file, String status, String description, HttpServletRequest request) throws IOException {
        Shuffling shuffling = new Shuffling();
        shuffling.setId(UUID.randomUUID().toString().replace("-",""));
        shuffling.setPath(file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf(".")));
        shuffling.setDescription(description);
        shuffling.setDate(new Date());
        shuffling.setStatus(status);
        String realPath = request.getSession().getServletContext().getRealPath("/images/").replace(request.getContextPath().replace("/","\\"),"");
        FileUtils.copyInputStreamToFile(file.getInputStream(),new File(realPath,file.getOriginalFilename()));
        int result = ss.addPic(shuffling);
        if(result>0){
            return shuffling;
        }else{
            return null;
        }
    }

    @RequestMapping("/updatePic")
    @ResponseBody
    public Shuffling updatePic(String pid,String path, String status, String description){
        Shuffling shuffling = new Shuffling();
        shuffling.setId(pid);
        shuffling.setPath(path);
        shuffling.setDescription(description);
        shuffling.setDate(new Date());
        shuffling.setStatus(status);
        int result = ss.addPic(shuffling);
        if(result>0){
            return shuffling;
        }else{
            return null;
        }
    }

}
