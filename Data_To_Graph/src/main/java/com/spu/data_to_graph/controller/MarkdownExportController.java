package com.spu.data_to_graph.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkdownExportController {

//    @GetMapping("/export")
//    public ResponseEntity<InputStreamResource> exportMdFiles() {
//        List<MdFile> mdFiles = getMdFiles(); // Replace with your own logic to get the MdFile objects
//        String filenamePrefix = "md-files";
//        InputStreamResource resource = new ZipInputStreamResource(mdFiles, filenamePrefix);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        headers.setContentDispositionFormData("attachment", resource.getFilename());
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(resource);
//    }
}