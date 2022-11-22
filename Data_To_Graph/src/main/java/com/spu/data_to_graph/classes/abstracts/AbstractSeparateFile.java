package com.spu.data_to_graph.classes.abstracts;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.spu.data_to_graph.classes.interfaces.FileConvert;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public abstract class AbstractSeparateFile implements FileConvert {

    @Override
    public List convert(File f) throws IOException, CsvException {

        CSVReader reader = new CSVReaderBuilder(new FileReader("yourfile.csv")).build();
        List<String[]> myEntries = reader.readAll();
        return null;
    }
}
