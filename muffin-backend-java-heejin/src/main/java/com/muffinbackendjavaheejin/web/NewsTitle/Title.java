package com.muffinbackendjavaheejin.web.NewsTitle;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "title")
public class Title{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "title_id") private Long titleId;
    @Column(name = "title_name") private String titleName;

    public Title(){}

    @Builder
    Title(String titleName){
        this.titleName = titleName;
    }

}