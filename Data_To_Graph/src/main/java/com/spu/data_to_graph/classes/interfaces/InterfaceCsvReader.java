package com.spu.data_to_graph.classes.interfaces;

import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface InterfaceCsvReader<E>{
    public List<E> convert(InputStream f) throws IOException, CsvException;

    public List convert(InputStream f, char separator) throws IOException, CsvException;
}