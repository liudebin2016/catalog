package com.jusfoun.catalog.controller;


import com.alibaba.fastjson.JSON;
//import com.ezubo.connor.cms.message.Code;
//import com.ezubo.connor.cms.message.Message;
//import com.ezubo.connor.cms.service.IUserService;

import com.jusfoun.catalog.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by huanglei on 15/12/27.
 */
@Controller
public class DashboardController extends BaseController{


//    @Autowired
//    private IUserService userService;


    @RequestMapping(value = "${adminPath}/dashboard", method = RequestMethod.GET)
    public String loadHomePage(Model m) {
//        m.addAttribute("name", "CodeTutr");
        return "admin/test";
    }

    @RequestMapping("partials/skin-config")
    public String loadSkinConfig(Model m) {
//        m.addAttribute("name", "CodeTutr");
        return "partials/skin-config";
    }


    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/upgrade-your-browser")
    public String upgradeYourBrowser() {
        return "upgrade-your-browser";
    }

    @RequestMapping(value = "/upgrade-your-browser",method = RequestMethod.POST)
    public String login(){
        return "";
    }

//    @RequestMapping(value="/header")
//    @ModelAttribute
//    public void login(@RequestParam(value="name", required=true) String name,@RequestParam(value="password", required=true) String password,HttpServletResponse response) {
//
//        System.out.println(name);
//        System.out.println(password);
//
//        Message message = new Message();
//        message.setSuccess(true);
//        message.setMessage(Code.E4000001);
//        String jsonString = JSON.toJSONString(message);
//
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setContentType("text/json;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        out.write(jsonString);
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON);
////        return new ResponseEntity<String>(jsonString,
////                headers, HttpStatus.OK);
//
//    }

}
