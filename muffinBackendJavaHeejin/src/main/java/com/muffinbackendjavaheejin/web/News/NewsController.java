package com.muffinbackendjavaheejin.web.News;

import com.muffinbackendjavaheejin.web.Utiles.Box;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private NewsService newsService;

    @GetMapping("/csv")
    public void csvRead(){ newsService.readCsv(); }

    @GetMapping("newsKeyword/{newsKeyword}")
    public Box<List<News>> findByNewsKeyword(@PathVariable String newsKeyword){
        return newsService.findByNewsKeyword(newsKeyword);
    }
}
