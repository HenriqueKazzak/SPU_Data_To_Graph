package com.spu.data_to_graph.models;

import com.spu.data_to_graph.classes.abstracts.AbstractCsvReader;

import java.util.List;

public class CsvReader extends AbstractCsvReader {

    public List<String[]> getFileConvert(){
        return fileConverted;
    }

}
