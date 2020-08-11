package com.muffinbackendjavaheejin.web.News;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@ToString
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id") private int newsId;
    @Column(name = "news_thumbnail") private String newsThumbnail;
    @Column(name = "news_title") private String newsTitle;
    @Column(name = "news_regDate") private String newsRegDate;
    @Column(name = "news_content") private String newsContent;
    @Column(name = "news_keyword") private String newsKeyword;

    public News(){}

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsThumbnail='" + newsThumbnail + '\'' +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsRegDate='" + newsRegDate + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newsKeyword='" + newsKeyword + '\'' +
                '}';
    }

    @Builder
    News(Integer newsId, String newsThumbnail, String newsTitle,
         String newsRegDate, String newsContent, String newsKeyword){
        this.newsId = newsId;
        this.newsThumbnail = newsThumbnail;
        this.newsTitle = newsTitle;
        this.newsRegDate = newsRegDate;
        this.newsContent = newsContent;
        this.newsKeyword = newsKeyword;
    }
}
