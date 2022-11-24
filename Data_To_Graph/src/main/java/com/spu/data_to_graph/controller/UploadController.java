package com.spu.data_to_graph.controller;

import com.opencsv.exceptions.CsvException;
import com.spu.data_to_graph.models.CsvReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

/**
 * Controller
 */
@Controller
public class UploadController {


    /**
     *
     * @param file is the uploaded at the index
     * @param redirectAttributes attributes to redirect
     * @return to {{@link IndexController}}
     */

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException, CsvException {
        redirectAttributes.addFlashAttribute("message",file.getOriginalFilename());


        CsvReader fileConvert = new CsvReader();
        List<String[]> separatedFile =  fileConvert.convert(file.getInputStream());

        redirectAttributes.addFlashAttribute("file",separatedFile);

        return "redirect:/";
    }
}
