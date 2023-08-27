package com.hello.hellospring.controller;


import com.hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

}
