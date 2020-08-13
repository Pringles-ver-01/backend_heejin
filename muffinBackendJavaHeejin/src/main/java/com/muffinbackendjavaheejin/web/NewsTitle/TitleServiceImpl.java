package com.muffinbackendjavaheejin.web.NewsTitle;

import com.muffinbackendjavaheejin.web.Utiles.GenericService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

interface TitleService extends GenericService<Title> {
    public void readCsv();
   /* List<Title> showData();*/
}


@Service
public class TitleServiceImpl implements TitleService{

    private final TitleRepository repository;

    public TitleServiceImpl(TitleRepository repository) {
        this.repository = repository;
    }


    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/title_result.csv");
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for(CSVRecord csvRecord : csvRecords){
                repository.save(new Title(
                        csvRecord.get(0)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
/*
    @Override
    public List<Title> showData() {
        return repository.selectAllTitle();
    }*/


    @Override
    public Optional<Title> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Title> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public boolean exist(long id) {
        return false;
    }
}
