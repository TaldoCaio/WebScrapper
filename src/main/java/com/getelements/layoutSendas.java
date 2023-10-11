package com.getelements;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class layoutSendas {
    private Document document;

    public layoutSendas(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getItem(){
        Elements linhas = document.select("table#tabResult tbody tr");
        List<ItemNotaFiscal> itens = new ArrayList<>();


        for (Element linha : linhas) {
            String descricao = linha.select("span.txtTit").text();
            String quantidade = (linha.select("span.Rqtd").text()).trim();
            String unidade = linha.select("span.RUN").text();
            String valorBruto = linha.select("span.valor").text();

            String[] quantFormatado = quantidade.split(":");
            String[] unidadeFormatado = unidade.split(":");

            if (!descricao.isEmpty() && !quantidade.isEmpty() && !unidade.isEmpty()
                    && !valorBruto.isEmpty()) {
                ItemNotaFiscal item = new ItemNotaFiscal(descricao, quantFormatado[1], unidadeFormatado[1], valorBruto);
                itens.add(item);
            }
        }
        for(ItemNotaFiscal item: itens){
            exibirItemNaTela(item);
        }
        return null;
    }

    public void exibirItemNaTela(ItemNotaFiscal item) {
        System.out.println("Descrição: " + item.getDescricao());
        System.out.println("Quantidade: " + item.getQuantidade());
        System.out.println("Unidade: " + item.getUnidade());
        System.out.println("Valor Bruto: " + item.getValorBruto());
        System.out.println();
    }


}
