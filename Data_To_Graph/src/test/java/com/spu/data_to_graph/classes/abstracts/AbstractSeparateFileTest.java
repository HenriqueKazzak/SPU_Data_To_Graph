package com.spu.data_to_graph.classes.abstracts;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class AbstractSeparateFileTest {

    public static void main(String... args) throws IOException, CsvException {

        CSVReader reader = new CSVReaderBuilder(new FileReader("D:\\Users\\henrique.karmierczak\\Downloads\\EXEMPLO GRAFOS - Delimitador Ponto e Vírgula.csv"))
                .withCSVParser(new CSVParserBuilder()
                        .withSeparator(';')
                        .build())
                .build();
        List<String[]> myEntries = reader.readAll();
        for (String[] s:myEntries) {
            for (String r : s) {
                System.out.print(r + "    |    ");

            }

        }

    }
}