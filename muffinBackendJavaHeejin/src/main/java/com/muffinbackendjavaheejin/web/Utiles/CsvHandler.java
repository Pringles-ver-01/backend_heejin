package com.muffinbackendjavaheejin.web.Utiles;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvHandler {
    public List<String []> readCsv(){
        InputStream in = getClass().getResourceAsStream("/static/news.csv");
        List<String []> data = new ArrayList<String []>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(in, "UTF-8"), ',', '"', 1);
            String [] s;
            while ((s =reader.readNext()) != null) {
                data.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
