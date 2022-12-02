package com.spu.data_to_graph.models;

import com.spu.data_to_graph.classes.interfaces.InterfaceSeparatedFile;

import java.util.List;

public class SeparatedFile implements InterfaceSeparatedFile {

    private FileData fileData;

    public FileData getFileData() {
        return fileData;
    }
    public void setFileData(FileData fileData) {
        this.fileData = fileData;
    }

    public SeparatedFile(List<String[]> list){
        this.fileData = new FileData();
    }

    public SeparatedFile(){
        this.fileData = new FileData();
    }

}
