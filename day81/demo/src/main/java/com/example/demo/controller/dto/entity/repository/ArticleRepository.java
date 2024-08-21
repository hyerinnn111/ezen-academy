package com.example.demo.repository;
import com.example.demo.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    // CrudRepository는 JPA에서 쓰는 인터페이스로 엔티티관리가능
    // <Article, Long> article객체의 대표값입니다
}