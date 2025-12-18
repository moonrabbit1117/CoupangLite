package com.example.CoupangLite.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index"; // templates/index.html 로 이동!!

        //HomeController 를 만드는 이유?
        // -> 그냥 localhost:8080 했을때 index.html 은 정적 렌더링이라 동적 thymeleaf를 읽지못함.
        // templates 안에 두는 html들은 controller가 필수.
        // / 는 무조건 index.html을 보여달라고 못박는것.
    }
}
