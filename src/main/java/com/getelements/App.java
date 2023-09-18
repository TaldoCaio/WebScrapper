package com.getelements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\caiolima.FIEG\\Downloads\\nota-fiscal\\teste.html";

        try {

            Document document = Jsoup.parse(new File(filePath), "UTF-8");
            Elements linhas = document.select("tr.highlighted");
            List<ItemNotaFiscal> itens = new ArrayList<>();


            for (Element linha : linhas) {
                String numero = linha.select("td.fixo-prod-serv-numero span").text();
                String descricao = linha.select("td.fixo-prod-serv-descricao span").text();
                String quantidade = linha.select("td.fixo-prod-serv-qtd span").text();
                String unidade = linha.select("td.fixo-prod-serv-uc span").text();
                String valorBruto = linha.select("td.fixo-prod-serv-vb span").text();

                ItemNotaFiscal item = new ItemNotaFiscal(numero, descricao, quantidade, unidade, valorBruto);
                itens.add(item);
            }

            for (ItemNotaFiscal item : itens) {
                System.out.println("Número: " + item.getNumero());
                System.out.println("Descrição: " + item.getDescricao());
                System.out.println("Quantidade: " + item.getQuantidade());
                System.out.println("Unidade: " + item.getUnidade());
                System.out.println("Valor Bruto: " + item.getValorBruto());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ItemNotaFiscal {
    private String numero;
    private String descricao;
    private String quantidade;
    private String unidade;
    private String valorBruto;

    public ItemNotaFiscal(String numero, String descricao, String quantidade, String unidade, String valorBruto) {
        this.numero = numero;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.valorBruto = valorBruto;
    }

    public String getNumero() {
        return numero;
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
