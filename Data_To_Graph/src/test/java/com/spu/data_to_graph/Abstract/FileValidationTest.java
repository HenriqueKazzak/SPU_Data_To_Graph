package com.spu.data_to_graph.Abstract;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileValidationTest extends FileValidation {

    @Override
    public String getExtension(@NotNull String file) {
        return super.getExtension(file);
    }

    @Test
    void getExtension() {
        assertEquals("txt",getExtension("teste.txt"));
        assertEquals("csv",getExtension("teste.csv"));
    }
}