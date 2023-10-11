package com.getelements;

class ItemNotaFiscal {
    private String descricao;
    private String quantidade;
    private String unidade;
    private String valorBruto;


    public ItemNotaFiscal(String descricao, String quantidade, String unidade, String valorBruto) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.valorBruto = valorBruto;
    }


    public String getDescricao() {
        return descricao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getValorBruto() {
        return valorBruto;
    }
}