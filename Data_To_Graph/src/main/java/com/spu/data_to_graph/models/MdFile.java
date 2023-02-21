package com.spu.data_to_graph.models;


public class MdFile {
    private String nomeArq;
    private String conteudo;

    public MdFile(String nomeArq, String conteudo) {
        this.nomeArq = nomeArq;
        this.conteudo = conteudo;
    }
    public MdFile() {
    }

    public String getNomeArq() {
        return nomeArq;
    }

    public void setNomeArq(String nomeArq) {
        this.nomeArq = nomeArq;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = this.conteudo +"/n"+ conteudo;
    }
}
