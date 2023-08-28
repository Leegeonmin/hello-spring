package com.hello.hellospring.controller;


import com.hello.hellospring.domain.Member;
import com.hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Autowired는 스프링에 MemberController를 등록할 때(생성자를 호출할 때)
 * MemberService에 연결해줌
 * Controller에서는 @Autowired를 생성자에 사용해 서비스에 연결해주고
 * Service class는 @Service, Repository class는 @Repository를 써주면 스프링 실행 시 호출함
 */
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("members/new")
    public String CreateForm(){
        return "members/createMemberForm.html";
    }

    @PostMapping("/members/new")
    public String create(  MemberForm form){
        Member member = new Member();
        member.setName(form.getName());


        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String List(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }

}
