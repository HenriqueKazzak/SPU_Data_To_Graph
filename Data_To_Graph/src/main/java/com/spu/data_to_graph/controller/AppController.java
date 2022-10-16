package com.spu.data_to_graph.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {


    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }
}
