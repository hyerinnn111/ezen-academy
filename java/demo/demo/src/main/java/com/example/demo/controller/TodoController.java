package com.example.demo.controller;

import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoEntity;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {


    @Autowired
    private TodoService service;
    // @AuthenticationPrincipal 인증정보에 대한 부분을 정의한 인터페이스이며
    // 이는 인증되는 주체의 id이다
    @PostMapping
    public ResponseEntity<?> createTodo(
            @AuthenticationPrincipal String userId,
            @RequestBody TodoDTO dto
    ) {
        try {
            // todoDto를 todoEntity로 변환
            TodoEntity entity = TodoDTO.toEntity(dto);
            // 게시글 생성당시엔 id가 없으니 id를 null초기화
            entity.setId(null);
            // userId 받아오기 (설정)
            entity.setUserId(userId);
            // todo 엔티티를 생성
            List<TodoEntity> entities = service.create(entity);
        }
        catch (Exception e) {
            //return
        }
    }



}
