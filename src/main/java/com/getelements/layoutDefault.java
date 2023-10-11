package com.getelements;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class layoutDefault {
    private Document document;

    public layoutDefault(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getItem(){
        Elements linhas = document.select("table tr");
        List<ItemNotaFiscal> itens = new ArrayList<>();


        for (Element linha : linhas) {
            String descricao = linha.select("td.fixo-prod-serv-descricao span").text();
            String quantidade = linha.select("td.fixo-prod-serv-qtd span").text();
            String unidade = linha.select("td.fixo-prod-serv-uc span").text();
            String valorBruto = linha.select("td.fixo-prod-serv-vb span").text();

            if (!descricao.isEmpty() && !quantidade.isEmpty() && !unidade.isEmpty()
                    && !valorBruto.isEmpty()) {
                ItemNotaFiscal item = new ItemNotaFiscal(descricao, quantidade, unidade, valorBruto);
                itens.add(item);
            }
        }

        for(ItemNotaFiscal item: itens){
            exibirItemNaTela(item);
        }
        return null;
    }

    private void exibirItemNaTela(ItemNotaFiscal item) {
        System.out.println("Descrição: " + item.getDescricao());
        System.out.println("Quantidade: " + item.getQuantidade());
        System.out.println("Unidade: " + item.getUnidade());
        System.out.println("Valor Bruto: " + item.getValorBruto());
        System.out.println();
    }
}
