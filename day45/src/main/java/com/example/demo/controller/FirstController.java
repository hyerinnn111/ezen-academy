package com.example.demo.controller;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //이 클래스는 서버의 요청과 응답을 처리하는
//콘트롤러 기능을 하는 것을 선언합니다
public class FirstController {
    @GetMapping("/hi")
    // 이 메서드는 hi라는 url을 가집니다
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "메가커피");
        return "greetings";
    }
    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "컴포즈");
    return "goodbye";
    }
}
