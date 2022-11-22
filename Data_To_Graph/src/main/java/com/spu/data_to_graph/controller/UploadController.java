package com.spu.data_to_graph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller of the upload.html
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    /**
     *
     * @param file is the uploaded at the index
     * @param redirectAttributes attributes to redirect
     * @return to {{@link IndexController}}
     */
    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message",file.getOriginalFilename());
        return "redirect:/";
    }
}
