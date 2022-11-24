package com.spu.data_to_graph.classes.abstracts;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.spu.data_to_graph.classes.interfaces.InterfaceCsvReader;

import java.io.*;
import java.util.List;

public abstract class AbstractCsvReader implements InterfaceCsvReader {
    public List<String[]> fileConverted;
    @Override
    public List<String[]> convert(InputStream isr) throws IOException, CsvException {

        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(isr)).build()) {
            this.fileConverted = reader.readAll();
            return fileConverted;
        }
        catch (Exception e){
            return null;
        }

    }
    @Override
    public List<String[]> convert(InputStream f, char separator) throws IOException, CsvException {
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
