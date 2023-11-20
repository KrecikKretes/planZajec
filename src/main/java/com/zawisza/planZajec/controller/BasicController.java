package com.zawisza.planZajec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    @GetMapping("/error")
    @ResponseBody
    public String error(){
        return "error";
    }

    @GetMapping("/work")
    @ResponseBody
    public String work(){
        return "Work";
    }

    @GetMapping("/")
    public String search(){
        return "index";
    }

}
