package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
     MemoryMemberRepository repository = new MemoryMemberRepository();

     // @AfterEach는 모든 메서드가 끝난 뒤 실행되는 callback 함수
     @AfterEach
     public void afterEach(){
          repository.clearStore();
     }
     //Test Attribute는 실행가능함
     @Test
     public void save(){
          Member member = new Member();
          member.setName("spring");
          repository.save(member);

          Member result = repository.findById(member.getId()).get();

          Assertions.assertEquals(result, member);
          assertThat(member).isEqualTo(result);

     }

     @Test
     public void findByName(){
          Member member1 = new Member();
          member1.setName("spring1");
          repository.save(member1);

          Member member2= new Member();
          member2.setName("spring2");
          repository.save(member2);

          Member result = repository.findByName("spring1").get();
          assertThat(result).isEqualTo(member1);
     }

     @Test
     public void findAll(){
          Member member1 = new Member();
          member1.setName("spring1");
          repository.save(member1);
          Member member2 = new Member();
          member2.setName("spring1");
          repository.save(member2);
          Member member3 = new Member();
          member3.setName("spring1");
          repository.save(member3);

          int result = (int) repository.findAll().stream().count();

          assertThat(result).isEqualTo(3);
     }
}
