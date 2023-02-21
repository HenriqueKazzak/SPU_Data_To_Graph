package com.spu.data_to_graph.controller;

import com.spu.data_to_graph.models.MdData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("mdData", new MdData());
        return "index";
    }

}

