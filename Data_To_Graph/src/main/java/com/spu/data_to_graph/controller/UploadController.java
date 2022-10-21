package com.spu.data_to_graph.controller;

import com.spu.data_to_graph.Abstract.FileValidation;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController extends FileValidation {
    @Override
    public String getExtension(@NotNull String file) {
        return super.getExtension(file);
    }

    @PostMapping("/Upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){

        if (file.isEmpty() || !getExtension(file.getName()).toLowerCase().equals("csv")){
            redirectAttributes.addFlashAttribute("message", "Por favor, selecione um arquivo CSV");
            return "index";
        }
        return "Upload";
    }
}
