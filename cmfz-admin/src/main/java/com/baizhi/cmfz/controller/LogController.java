package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by zxl on 2018/7/10.
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService ls;
    @RequestMapping("/showAllLog")
    @ResponseBody
    public Map<String,Object> showAllLog(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        return ls.queryAllLog(page, rows);
    }
}
