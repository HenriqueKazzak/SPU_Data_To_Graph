package com.spu.data_to_graph.classes.interfaces;

import java.util.List;

public interface InterfaceFileData<E> {
    public List<E> getRow(int index);
    public List<E> getColum(int index);
    public List<E> getAllData();
}
