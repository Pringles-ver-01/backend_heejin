package com.muffinbackendjavaheejin.web.News;
/*
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.util.List;

interface INewsRepository{

    List<News> fetchByNewsId(int newsId);
    List<News> fetchByNewsKeyword(String newsKeyword);

}*/
/*

@Repository
public class NewsRepositoryImpl extends QuerydslRepositorySupport implements INewsRepository {


    private final JPAQueryFactory queryFactory;
    private final DataSource dataSource;

    NewsRepositoryImpl(JPAQueryFactory queryFactory, DataSource dataSource) {
        super(News.class);
        this.queryFactory = queryFactory;
        this.dataSource = dataSource;
    }


    @Override
    public List<News> fetchByNewsId(int newsId) {
        QNews qNews = QNews.news;
        return queryFactory.selectFrom(qNews)
                .where(qNews.newsId.eq(1))
                .fetch();
    }

    @Override
    public List<News> fetchByNewsKeyword(String newsKeyword){
        return queryFactory.selectFrom(news)
                .where(newsKeyword.eq(newsKeyword))
                .fetch();
    }
}
*/
