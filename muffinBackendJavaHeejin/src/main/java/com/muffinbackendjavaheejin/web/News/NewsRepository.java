package com.muffinbackendjavaheejin.web.News;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface NewsRepository extends JpaRepository<News,Integer>/*, INewsRepository*/ {

    List<News> findByNewsKeyword(String newsKeyword);

    @Query("select e from News e")
    List<News> selectAllNews();

}
