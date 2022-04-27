package com.example.bouncingball_f4_spring_inswing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return ("templates/index.html");
    }

}
