package com.example.demo.dto;

import com.example.demo.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title;
    private String content;



    public Article toEntity() {
        return new Article(null, title, content);
        //폼데이터를 담은 DTO객체를 엔티티로 변환합니다
    }


}
