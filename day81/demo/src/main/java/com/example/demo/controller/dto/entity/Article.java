package com.example.demo.entity;

import com.example.demo.controller.dto.ALlArgsConstructor;
import com.example.demo.controller.dto.entity.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Tostring;

@ALlArgsConstructor
@ToString
@Entity
public class Article {
    @Id //대표값 sql의 primary key
    @GeneratedValue // auto increment
    private Long Id;
    @Column
    private String title;
    @Column
    private String content;
}

