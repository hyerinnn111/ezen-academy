package com.example.demo.controller;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j
@Controller
public class ArticleController {
    @Autowired
    // 스프링은 어노테이션을 통해 알아서 객체를 만듭니다
    private ArticleRepository articleRepository ;
    @GetMapping("articles/new")
    public String newArticleForm() {
        return "articles/new";
    }
    @PostMapping("articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());
        // System.out.println(form.toString());
        // 1.DTO를 변환
        Article article = form.toEntity();
        System.out.println(article.toString());
        // 2. 저장소에 엔티티를 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        System.out.println(saved.toString());

        return "";
    }

}