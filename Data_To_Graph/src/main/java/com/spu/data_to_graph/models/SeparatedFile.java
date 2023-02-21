package com.spu.data_to_graph.models;

public class SeparatedFile {

    private FileData fileData;

    public FileData getFileData() {
        return fileData;
    }
    public void setFileData(FileData fileData) {
        this.fileData = fileData;
    }

    public SeparatedFile(){
        this.fileData = new FileData();
    }

}
