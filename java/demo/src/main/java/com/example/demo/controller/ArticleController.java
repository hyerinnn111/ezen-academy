package com.example.demo.controller;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
        log.info(form.toString());
        // System.out.println(form.toString());
        // 1.DTO를 변환
        Article article = form.toEntity();
        log.info(article.toString());
        // System.out.println(article.toString());
        // 2. 저장소에 엔티티를 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return "redirect:/articles/" + saved.getId();
    }

    // 서버의 컨트롤러가 url요청을 받을 수 있습니다
    @GetMapping("articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id is" + id);
//        1. id를 조회해서 데이터 받아오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
//        2. 데이터 등록하기
//        3. 뷰 템플릿 반환
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 데이터 가져오기
        // 리스트 자료형에서 모든 데이터를 찾아서 가져온다
        List<Article> articleEntityList = articleRepository.findAll();
        //  2. 데이터 등록하기
        // 데이터를 리스트 자료형으로 진행 하게되면 타입 불일치 문제가 발생한다
        // 리포지토리안의 자료형은 Article인데 리스트자료형이 아니기때문이다.
        // 그래서 상속받은 기본 CrudRepository<Article, Long>
        // 리스트 자료형을 지원하지 않았다. 자료형 충돌이슈!!!!
        //
        model.addAttribute("articleList", articleEntityList);
//        3. 뷰 템플릿 반환
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "articles/edit";
    }

    @PostMapping("articles/update")
    public String update(ArticleForm form) {
        log.info(form.toString());
        //1. DTO엔티티로 바꾸기
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());
        //2. 엔티티를 db에 저장하기
        Article target = articleRepository
                .findById(articleEntity.getId()).orElse(null);
        if (target != null) {
            articleRepository.save(articleEntity);
        }
        return "redirect:/articles/" + articleEntity.getId();
    }

}

        @GetMapping("/articles/{id}/delete")
                public String delete(@PathVariable Long id, RedirectAttributes rttr) {
            log.info("삭제 하라는데요?");
            // 1. 삭제데이터 가져오기
            Article target = articleRepository.findById(id).orElse(null);
            log.info(target.toString());
            if (target != null) {
                articleRepository.delete(target);
                // addFlashAttribute는 리다이렉트 시점에 한번만 보여줄 데이터
                // 삭제 메세지를 리다이렉트 시점에 한번만 보여주려고 RedirectAttributes 불러서 사용
                rttr.addFlashAttribute( attributeName:"msg", attributeValue: "삭제되었음");
            }
            return "redirect:/articles";
        }
    }
}
