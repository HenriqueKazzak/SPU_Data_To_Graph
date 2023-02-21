package com.spu.data_to_graph;

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

    private List<InputStreamResource> resources;
    private List<MdFile> mdFileList;

    public ZipInputStreamResource(List<InputStreamResource> resources, List<MdFile> mdFileList) {
        super(createZipInputStream(resources, mdFileList));
        this.resources = resources;
        this.mdFileList = mdFileList;
    }

    private static InputStream createZipInputStream(List<InputStreamResource> resources, List<MdFile> mdFileList) {
        try {
            // Create a ByteArrayOutputStream to write the zip file to
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            // Create a ZipOutputStream that writes to the ByteArrayOutputStream
            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
            // Loop through the InputStreamResources and add each one to the zip file as a separate entry
            for (int i = 0; i < resources.size(); i++) {
                InputStreamResource resource = resources.get(i);
                ZipEntry entry = new ZipEntry(mdFileList.get(i).getNomeArq());
                zipOutputStream.putNextEntry(entry);
                byte[] bytes = resource.getInputStream().readAllBytes();
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
        return mdFileList + ".zip";
    }
}
