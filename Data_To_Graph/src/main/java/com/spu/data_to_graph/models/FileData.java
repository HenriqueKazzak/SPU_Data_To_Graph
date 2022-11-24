package com.spu.data_to_graph.models;


import com.spu.data_to_graph.classes.interfaces.InterfaceFileData;

import java.util.List;

public class FileData implements InterfaceFileData {
    private List<String[]> file;

    public FileData(List<String[]> file){
        this.file = file;
    }
    public FileData(){
        this.file = null;
    }
    @Override
    public List getRow(int index) {
        return List.of(this.file.get(index));
    }

    @Override
    public List getColum(int index) {
        return List.of(this.file.get(index));
    }

    @Override
    public List getAllData(int index) {
        return List.of(this.file.get(index));
    }
}
