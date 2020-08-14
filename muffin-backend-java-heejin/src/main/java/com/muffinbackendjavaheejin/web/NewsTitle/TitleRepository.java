package com.muffinbackendjavaheejin.web.NewsTitle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {

}
