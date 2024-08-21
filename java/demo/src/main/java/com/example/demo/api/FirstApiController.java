package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// rest 컨트롤러와 일반의 차이점??
// return문에서 프론트 페이지를 주느냐 데이터를 주느냐

@RestController
public class FirstApiController {
    @GetMapping("/api/hello")
    public String hello() {
        return "안녕하세요~";
    }
}
