package com.getelements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;


public class App {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\caiolima.FIEG\\Desktop\\nota-fiscal\\teste4.html";

        try {
            Document document = Jsoup.parse(new File(filePath), "UTF-8");
            identificadorLayout identificadorLayout = new identificadorLayout(document);

            identificadorLayout.getLayout();

        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}

