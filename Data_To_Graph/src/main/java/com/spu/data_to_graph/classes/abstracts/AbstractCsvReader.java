package com.spu.data_to_graph.classes.abstracts;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.util.List;

public abstract class AbstractCsvReader {
    protected List<String[]> fileConverted;
    public List<String[]> convert(InputStream isr) {

        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(isr)).build()) {
            this.fileConverted = reader.readAll();
            return fileConverted;
        }
        catch (Exception e){
            return null;
        }

    }

    public List<String[]> convert(InputStream f, char separator){
        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(f))
                .withCSVParser(new CSVParserBuilder()
                        .withSeparator(separator)
                        .build())
                .build()){
            this.fileConverted = reader.readAll();
            return fileConverted;
        }
        catch (Exception e){
            return null;
        }
    }
}
