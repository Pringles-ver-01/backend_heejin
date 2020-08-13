package com.muffinbackendjavaheejin.web.NewsTitle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
/*    @Query ("select e from Title e")
    List<Title> selectAllTitle();*/
}
