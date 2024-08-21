package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Article {
    @Id //대표값 sql의 primary key
    @GeneratedValue // auto increment
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        // 업데이트 할 내용이 있을때만 작동시키면 된다
        if (article.title != null) {
            this.title = article.title;
        }
        if (article.content != null) {
            this.content = article.content;
        }
    }
}
