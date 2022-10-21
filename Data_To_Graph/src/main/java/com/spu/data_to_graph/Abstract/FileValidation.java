package com.spu.data_to_graph.Abstract;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class FileValidation {
    public String getExtension(@NotNull String file){
        List<String> list = Arrays.asList(file.split("\\."));
        return list.get(list.size()-1);
    }
}

