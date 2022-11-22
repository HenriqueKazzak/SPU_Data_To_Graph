package com.spu.data_to_graph.classes.interfaces;

import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileConvert <E>{
    public List<E> convert(File f) throws IOException, CsvException;
}