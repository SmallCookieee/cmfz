package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.service.GuruService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zxl on 2018/7/9.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService as;
    @Autowired
    private GuruService gs;
    @RequestMapping("/showAllGuru")
    @ResponseBody
    public List<Guru> showAllGuru(){
//        List<Guru> list = gs.queryGuru();
//        for (Guru guru : list) {
//            System.out.println(guru);
//        }
        return gs.queryGuru();
    }
    @RequestMapping("/addArticle")
    @ResponseBody
    public Article addArticle(String articleName, String introduction,String articleAuthor, String articleStatus) throws IOException {
        Article article = new Article();
        article.setArticleId(UUID.randomUUID().toString().replace("-",""));
        article.setArticleName(articleName);
        article.setIntroduction(introduction);
        article.setArticleDate(new Date());
        article.setArticleAuthor(articleAuthor);
        article.setArticleStatus(articleStatus);
        System.out.println(article);
        int result = as.addArticle(article);
        if(result>0){
            return article;
        }else{
            return null;
        }
    }
    @RequestMapping("/upload")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException {
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<String>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\guruPic";
            if(files!=null && files.length!=0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    file.transferTo(new File(uploadPath+"\\"+fileName));
                    data.add(request.getContextPath()+"/guruPic/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }

}
