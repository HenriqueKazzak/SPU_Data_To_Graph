package com.spu.data_to_graph.models;


import java.util.List;

public class FileData extends CsvReader {

    private CsvReader csvReader;
    public CsvReader getCsvReader() {
        return csvReader;
    }

    public FileData(){
        this.csvReader = new CsvReader();
    }

    public void setCsvReader(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    public List getRow(int index) {
        return List.of(this.csvReader.getFileConvert().get(index));
    }


    public List getColum(int index) {
        return List.of(this.csvReader.getFileConvert().get(index));
    }


    public List<String[]> getAllData() {
        return this.csvReader.getFileConvert();
    }
}
