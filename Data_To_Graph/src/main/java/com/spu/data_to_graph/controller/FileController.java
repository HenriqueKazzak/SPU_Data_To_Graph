package com.spu.data_to_graph.controller;

import com.opencsv.exceptions.CsvException;
import com.spu.data_to_graph.models.GenerateMd;
import com.spu.data_to_graph.models.MdData;
import com.spu.data_to_graph.models.MdFile;
import com.spu.data_to_graph.models.SeparatedFile;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Controller
 */
@Controller
public class FileController {

    SeparatedFile separatedFile;

    /**
     *
     * @param file is the uploaded at the index
     * @param redirectAttributes attributes to redirect
     * @return to {{@link IndexController}}
     */
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes ) throws IOException, CsvException {
        redirectAttributes.addFlashAttribute("message",file.getOriginalFilename());

        this.separatedFile = new SeparatedFile();

        this.separatedFile.getFileData().getCsvReader().convert(file.getInputStream(),';');
        redirectAttributes.addFlashAttribute("file",this.separatedFile.getFileData().getAllData());
        return "redirect:/";
    }
    /**
     * generate file controller
     */
    @PostMapping(value = "/save")
    public ResponseEntity<InputStreamResource> saveFile(@ModelAttribute("mdForm") MdData mdData) throws IOException {
        String[] listColuna = mdData.getColuna().split(",");
        String[] listTipoDado = mdData.getTipoDado().split(",");
        GenerateMd generateMd = new GenerateMd(this.separatedFile,listTipoDado);
        InputStreamResource resource = createZipInputStreamResource(generateMd.getMdFileList(), Instant.now().toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String timestamp = Instant.now().toString();
        headers.setContentDispositionFormData("attachment", timestamp + ".zip");
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
    private InputStreamResource createZipInputStreamResource(List<MdFile> mdFiles, String filenamePrefix) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ZipOutputStream zos = new ZipOutputStream(baos)) {
            for (MdFile mdFile : mdFiles) {
                ZipEntry entry = new ZipEntry(filenamePrefix + "/" + mdFile.getNomeArq());
                zos.putNextEntry(entry);
                zos.write(mdFile.getConteudo().getBytes());
                zos.closeEntry();
            }
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        return new InputStreamResource(bais);
    }
}

