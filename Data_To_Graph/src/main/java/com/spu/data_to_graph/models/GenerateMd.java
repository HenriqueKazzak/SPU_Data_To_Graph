package com.spu.data_to_graph.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateMd {

    private List<MdFile> mdFileList;

    public GenerateMd(SeparatedFile separatedFile, String[] listTipoDado) throws IOException {
        mdFileList = new ArrayList<>();
            for (int i = 1; i < separatedFile.getFileData().getAllData().size(); i++) {
                List rowData = separatedFile.getFileData().getRow(i);
                MdFile mdFile = new MdFile();
                for (int j = 0; j < rowData.size(); j++) {
                    if (!listTipoDado[j].equals("empty")){
                        String replaceValue = listTipoDado[j].replace((CharSequence) "replace_value", (CharSequence) rowData.get(j));
                        if (listTipoDado[j].compareTo("replace_value.md") != 0){
                            mdFile.setConteudo(replaceValue);
                        }
                        else {
                            mdFile.setNomeArq(replaceValue);
                        }
                    }
                }
                if (mdFile.getNomeArq().isEmpty()){
                    mdFile.setNomeArq("fileMD"+i+".md");
                }
                this.mdFileList.add(mdFile);
        }
    }
    public List<MdFile> getMdFileList() {
        return mdFileList;
    }
}
