package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.IcodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by zxl on 2018/7/4.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService ms;

    @RequestMapping("/login")
    public String login(String name,String password,String enCode,HttpServletRequest request,HttpServletResponse response,boolean rememberName,boolean rememberMe) {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");
        if(code.equalsIgnoreCase(enCode)){
//            Manager manager = ms.login(name,password);
//            if(manager!=null){
//                session.setAttribute("manager",manager);
//                if(rememberName){
//                    Cookie cookie = new Cookie("name",name);
//                    cookie.setPath("/cmfz-admin");
//                    response.addCookie(cookie);
//                }
//                return "main";
//            }
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(new UsernamePasswordToken(name,password,rememberMe));
                Manager manager = ms.login(name,password);
                session.setAttribute("manager",manager);
                System.out.println(subject.hasRole("root") ? "有" : "无");
                return "main";
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                return "login";
            }catch (IncorrectCredentialsException ice){
                ice.printStackTrace();
                return "login";
            }catch (AuthenticationException ae){
                ae.printStackTrace();
                return "login";
            }
        }
        return "login";
    }

    @RequestMapping("/image")
    @ResponseBody
    public void getImage(HttpServletRequest request,HttpServletResponse response) throws IOException {
        char[] encode = IcodeUtil.getRandomChars();
        HttpSession session = request.getSession();
        String code = String.valueOf(encode);
        session.setAttribute("code",code);
        BufferedImage image = IcodeUtil.getImage(encode);
        ImageIO.write(image,"png",response.getOutputStream());
    }


}
