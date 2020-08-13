package com.muffinbackendjavaheejin.web.NewsTitle;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RequestMapping("/title")
public class TitleController {

    private static final Logger logger = LoggerFactory.getLogger(TitleController.class);
    private TitleService titleService;

    @GetMapping("/csv")
    public void csvRead(){
        titleService.readCsv();
    }

/*    @GetMapping("/test")
    public List<Title> getData(){
        logger.info("/title/test TitleController");
        return titleService.showData();
    }*/
}
