package com.ms.icalrestapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

    @RequestMapping("/")
    public String indexController(){
        return "index.html";
    }
}
