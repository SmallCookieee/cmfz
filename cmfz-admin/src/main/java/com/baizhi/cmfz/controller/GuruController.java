package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
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
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zxl on 2018/7/6.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    private GuruService gs;
    @RequestMapping("/showAllGuru")
    @ResponseBody
    public Map<String,Object> showAllGuru(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        return gs.queryAllGuru(page, rows);
    }
    @RequestMapping("/showGuruByName")
    @ResponseBody
    public Map<String,Object> showGuruByName(@RequestParam("name")String name,@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        return gs.queryGuruByName(name, page, rows);
    }

    @RequestMapping("/insertGuru")
    @ResponseBody
    public Guru insertGuru(String guruName,MultipartFile file,String guruSummary,HttpServletRequest request) throws IOException {
        Guru guru = new Guru();
        guru.setGuruId(UUID.randomUUID().toString().replace("-",""));
        guru.setGuruName(guruName);
        guru.setGuruPhoto(file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf(".")));
        guru.setGuruSummary(guruSummary);
        String realPath = request.getSession().getServletContext().getRealPath("/guruPic/").replace(request.getContextPath().replace("/","\\"),"");
        FileUtils.copyInputStreamToFile(file.getInputStream(),new File(realPath,file.getOriginalFilename()));
        int result = gs.addGuru(guru);
        if(result>0){
            return guru;
        }else{
            return null;
        }
    }
    @RequestMapping("/updateGuru")
    @ResponseBody
    public Guru modifyGuru(String guruId,String guruName,MultipartFile file,String guruSummary,HttpServletRequest request) throws IOException {
        Guru guru = new Guru();
        guru.setGuruId(guruId);
        guru.setGuruName(guruName);
        guru.setGuruPhoto(file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf(".")));
        guru.setGuruSummary(guruSummary);
        String realPath = request.getSession().getServletContext().getRealPath("/guruPic/").replace(request.getContextPath().replace("/","\\"),"");
        FileUtils.copyInputStreamToFile(file.getInputStream(),new File(realPath,file.getOriginalFilename()));
        int result = gs.modify(guru);
        if(result>0){
            return guru;
        }else{
            return null;
        }
    }
    @RequestMapping("/insertBatch")
    @ResponseBody
    public List<Guru> insertBatch(MultipartFile file) throws Exception {
        ImportParams importParams =  new ImportParams();
        List<Guru> gurus = ExcelImportUtil.importExcel(file.getInputStream(),Guru.class,importParams);
        gs.addGurus(gurus);
        System.out.println(gurus);
        return gurus;
    }
}
