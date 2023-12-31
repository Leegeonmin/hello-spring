package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
//@Service
public class MemberService
{
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원 X
        // 로직이 쭉 길어지면 메서드로 추출하자
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 젠처 회원 조회
     * 서비스 클래스는 Business logic에 의존적으로 이름을 짓는다
     */
    public List<Member> findMembers()
    {
            return memberRepository.findAll();
    }

    /**
     * 회원 조회(ID로)
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
    private void validateDuplicateMember(Member member) {
//        Optional<Member> result= memberRepository.findByName(member.getName());

        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }
}
