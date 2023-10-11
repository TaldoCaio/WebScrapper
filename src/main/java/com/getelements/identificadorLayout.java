package com.getelements;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class identificadorLayout {
    private Document document;


    public identificadorLayout(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void getLayout(){
        Elements divContent = document.select("div.ui-content");
        if (divContent.hasAttr("xmlns:n") && divContent.hasAttr("xmlns:chave")){
            layoutSendas layoutSendas = new layoutSendas(document);
            layoutSendas.getItem();
        }else {
            layoutDefault layoutDefault = new layoutDefault(document);
            layoutDefault.getItem();
        }
    }


}
