package com.spu.data_to_graph.models;


import com.spu.data_to_graph.classes.interfaces.InterfaceFileData;

import java.util.List;

public class FileData extends CsvReader implements InterfaceFileData{

    private CsvReader csvReader;
    public CsvReader getCsvReader() {
        return csvReader;
    }

    public void setCsvReader(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    public FileData(){
        this.csvReader = new CsvReader();
    }
    @Override
    public List getRow(int index) {
        return List.of(this.csvReader.getFileConvert().get(index));
    }

    @Override
    public List getColum(int index) {
        return List.of(this.csvReader.getFileConvert().get(index));
    }

    @Override
    public List<String[]> getAllData() {
        return this.csvReader.getFileConvert();
    }
}
