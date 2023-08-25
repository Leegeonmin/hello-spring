package com.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/* 빌드방법
* gradlew build  cmd로 입력
* build > libs > 파일을 "java -jar 파일이름" 으로 실행
* 서버는 결국 gradlew build의 결과물인 jar파일을 올려두기만 하고 실행시키기만 하면됨.
* */

/*
* web application의 시작 위치는 Controller
* @Controller Attribute 명시
* @GetMapping은 Get Method ,들어가는 string이 endpoint
* return string의 경우 viewResolver가 resources:templates/{returnstring}.html로 라우팅
*  */
@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "이건민!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name")  String testName, Model model){
        model.addAttribute("name", testName);
        return "hello-template";
    }


}
