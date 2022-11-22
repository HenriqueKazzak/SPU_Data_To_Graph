package com.spu.data_to_graph.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author henrique.karmierczak
 * @version 1.0
 */
@Controller
public class IndexController {

    /**
     * @param model receive a model
     * @return index.html file
     */
    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }
    @RequestMapping("/teste")
    public String teste(Model m){
        return "teste";
    }
}

