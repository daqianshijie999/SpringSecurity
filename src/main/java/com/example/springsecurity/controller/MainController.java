package com.example.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("toMain")
    public String main(){
        return "redirect:main.html";
    }

    @RequestMapping("toLogin")
    public String login(){
        return "redirect:login.html";
    }
}
