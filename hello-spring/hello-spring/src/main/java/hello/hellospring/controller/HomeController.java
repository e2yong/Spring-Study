package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 도메인/으로 들어오면 호출
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
