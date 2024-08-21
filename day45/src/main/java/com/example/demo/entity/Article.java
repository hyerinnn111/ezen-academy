package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Article {
    @Id //대표값 sql의 primary key
    @GeneratedValue // auto increment
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

}
