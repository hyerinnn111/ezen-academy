package com.example.demo.controller;

import com.example.demo.dto.MemberForm;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
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
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String newMemberForm() {
        return "members/new";
    }

    @GetMapping("/signup")
    public String signUpPage() {
        return "/members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm form) {
        // 1. DTO로 변환
        log.info(MemberForm.toString());
        Member member = MemberForm.toEntity();
        log.info(member.toString());
        // 2. 지정소에 엔티티를 저장
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return "redirect:/members/" + saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id is" + id);
        // 1. id를 조회해서 데이터 받아오기
        Member member= memberRepository.findById(id).orElse(null);
        // 2. 데이터 등록하기
        model.addAttribute("member", member);
        // 3. 뷰 템플릿 변환
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("member", members);
        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Member memberEntity = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", memberEntity);
        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form) {
        log.info(form.toString());
        // 1. 엔티티로 바꾸기
        Member memberEntity = form.toEntity();
        log.info(memberEntity.toString());
        Member target = memberRepository
                .findById(memberEntity.getId()).orElse(null);
        if (target != null) {
            memberRepository.save(memberEntity);
        }
        return "redirect:/members/" + memberEntity.getId();
    }


    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제 요청이 들어왔습니다!!");
        // 1. 삭제 대상을 가져옴
        Member target = memberRepository.findById(id).orElse(null);
        // 2. 대상 삭제
        log.info(target.toString());
        if (target != null) {
            memberRepository.delete(target);
            rttr.addFlashAttribute( attributeName:"msg", attributeValue: "삭제됨");
        }
        // 3. 결과 페이지로 리다이렉트
        return "redirect:/members";

    }
}