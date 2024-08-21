package com.example.demo.api;
import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class ArticleApiController {
    @Autowired
    private ArticleRepository articleRepository ;

    @GetMapping("/api/articles")
    public List<Article> index() {
        return  articleRepository.findAll();
    }

    @GetMapping("api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto) {
        // json데이터를 다루어야 하므로 dto 앞에 @RequestBody가 들어갑니다
        // 1.DTO를 변환
        Article article = dto.toEntity();
        // 2. 저장소에 엔티티를 저장
        return articleRepository.save(article);
    }

    //PATCH (편집/수정)
    @PatchMapping("/api/articles/{id}")
    // http관련 응답을 해야해서 ResponseEntity를 도입함
    public ResponseEntity<Article> update
    (@PathVariable Long id,@RequestBody ArticleForm dto) {
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        Article target = articleRepository.findById(id).orElse(null);
        // 잘못된 요청 처리하기
        if (target == null || id != article.getId()) {
            log.info("잘못된 요청입니다 id={}, article={}", id, article.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        target.patch(article);
        Article updated = articleRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        articleRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}