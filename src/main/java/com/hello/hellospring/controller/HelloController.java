package com.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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

    /* @ResponseBody Attribute 추가
    * 메소드의 반환값이 HTTP 응답 본문에 직접 작성되어야 함을 나타냅니다.
    * 즉, 반환된 값은 뷰 리졸버(View Resolver)를 통해 뷰 이름으로 해석되지 않고, 클라이언트에게 직접 반환됩니다.
    * */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
      return "hello " + name;
    }

    /* API 방식으로 리턴하는 Method
    * Hello 객체를 사용해서 return
    * Json 형식
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    public class Hello {
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
