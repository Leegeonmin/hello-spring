package com.hello.hellospring.domain;

import javax.persistence.*;

/**
 * Jpa를 사용하기 위한 엔티티 선언
 * @Id를 통한 PK선언
 */
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
