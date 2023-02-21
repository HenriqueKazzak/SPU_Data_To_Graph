package com.spu.data_to_graph.models;

public class MdData {
    private String coluna;
    private String tipoDado;

    public String getColuna() {
        return coluna;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }

    public String getTipoDado() {
        return tipoDado;
    }

    public void setTipoDado(String tipoDado) {
        this.tipoDado = tipoDado;
    }

    @Override
    public String toString() {
        return "MdForm{" +
                "coluna='" + coluna + '\'' +
                ", tipoDado='" + tipoDado + '\'' +
                '}';
    }
}
