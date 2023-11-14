package com.zawisza.planZajec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping(value= "/work")
    public String work(){
        return "Work";
    }

}
