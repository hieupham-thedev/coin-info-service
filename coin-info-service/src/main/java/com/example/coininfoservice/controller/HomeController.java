package com.example.coininfoservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/assets")
    public String getAssets() {
        return "assets";
    }

    @RequestMapping("/boughtAssets")
    public String getBoughtAssets() {
        return "bought-assets";
    }

}
