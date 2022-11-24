package com.spu.data_to_graph.models;

import com.spu.data_to_graph.classes.interfaces.InterfaceSeparatedFile;

import java.util.List;

public class SeparatedFile implements InterfaceSeparatedFile {

    public List fileConverted;
    public SeparatedFile(List list){
        this.fileConverted = list;
    }

    @Override
    public List getSeparatedFile() {
        return this.fileConverted;
    }
}
