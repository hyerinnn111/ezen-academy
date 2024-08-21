package com.example.demo.dto;

import com.example.demo.controller.dto.ALlArgsConstructor;
import com.example.demo.entity.Article;
import lombok.AllArgsConstructor;

@ALlArgsConstructor
public class ArticleForm {
    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
    //
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null, title, content);
        //폼데이터를 담은 DTO객체를 엔티티로 변환합니다
    }
}
