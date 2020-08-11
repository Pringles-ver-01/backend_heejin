package com.muffinbackendjavaheejin.web.News;


import com.muffinbackendjavaheejin.web.Utiles.Box;
import com.muffinbackendjavaheejin.web.Utiles.GenericService;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

interface NewsService extends GenericService<News> {
    public Box<List<News>> findByNewsKeyword(String newsKeyword);
    public void readCsv();

}
@Service
public class NewsServiceImpl implements NewsService{
    private final NewsRepository repository;
    private final Box<List<News>> news;

    public NewsServiceImpl(NewsRepository repository, Box<List<News>> news) {
        this.repository = repository;
        this.news = news;
    }

    @Override
    public Optional<News> findById(String id) {
        return repository.findById(Integer.parseInt(id));
    }

    @Override
    public Iterable<News> findAll() {
        return repository.findAll();
    }

    @Override
    public int count() {
        return (int)repository.count();
    }

    @Override
    public void delete(String id) {
        repository.delete(findById(id).orElse(new News()));
    }

    @Override
    public boolean exist(String id) {
        return repository.existsById(Integer.parseInt(id));
    }

    @Override
    public Box<List<News>> findByNewsKeyword(String newsKeyword) {
        news.put( (newsKeyword != null) ? newsKeyword  : "키워드 없음", repository.findByNewsKeyword(newsKeyword) );
        return news;
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/news.csv");
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for(CSVRecord csvRecord : csvRecords){
                //String  newsId, newsThumbnail, newsTitle, newsRegDate, newsContent, newsKeyWord;

                repository.save(new News(
                        Integer.parseInt(csvRecord.get(1)),
                        csvRecord.get(2),
                        csvRecord.get(3),
                        csvRecord.get(4),
                        csvRecord.get(5),
                        csvRecord.get(6)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
