package com.example.gtics_lab6_20200825.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalCotrolller {
    @GetMapping("/index")
    String index(){
        return "index";
    }
}
