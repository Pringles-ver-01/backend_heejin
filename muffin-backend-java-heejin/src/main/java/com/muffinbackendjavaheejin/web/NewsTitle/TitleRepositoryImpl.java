package com.muffinbackendjavaheejin.web.NewsTitle;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


interface ITitleRepository{

}

@Repository
public class TitleRepositoryImpl extends QuerydslRepositorySupport implements ITitleRepository {

    private final JPAQueryFactory queryFactory;
    private DataSource dataSource;
    private final TitleRepository repository;

    public TitleRepositoryImpl(JPAQueryFactory queryFactory, DataSource dataSource, @Qualifier("titleRepository") TitleRepository repository) {
        super(Title.class);
        this.queryFactory = queryFactory;
        this.dataSource = dataSource;
        this.repository = repository;
    }

}
