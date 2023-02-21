package com.spu.data_to_graph.utils;

import com.spu.data_to_graph.models.MdFile;
import org.springframework.core.io.InputStreamResource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipInputStreamResource extends InputStreamResource {

    private List<MdFile> files;
    private String filenamePrefix;

    public ZipInputStreamResource(List<MdFile> files, String filenamePrefix) {
        super(createZipInputStream(files, filenamePrefix));
        this.files = files;
        this.filenamePrefix = filenamePrefix;
    }

    private static InputStream createZipInputStream(List<MdFile> files, String filenamePrefix) {
        try {
            // Create a ByteArrayOutputStream to write the zip file to
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            // Create a ZipOutputStream that writes to the ByteArrayOutputStream
            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
            // Loop through the MdFile objects and add each one to the zip file as a separate entry
            for (int i = 0; i < files.size(); i++) {
                MdFile file = files.get(i);
                String filename = file.getNomeArq();
                ZipEntry entry = new ZipEntry(filename);
                zipOutputStream.putNextEntry(entry);
                byte[] bytes = file.getConteudo().getBytes();
                zipOutputStream.write(bytes, 0, bytes.length);
                zipOutputStream.closeEntry();
            }
            // Close the ZipOutputStream and ByteArrayOutputStream
            zipOutputStream.close();
            outputStream.close();
            // Create a new ByteArrayInputStream from the byte array of the zip file
            byte[] zipBytes = outputStream.toByteArray();
            return new ByteArrayInputStream(zipBytes);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create zip input stream: " + e.getMessage());
        }
    }

    public String getFilename() {
        return filenamePrefix + ".zip";
    }
}
