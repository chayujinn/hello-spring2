package hello2.hellospring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")//가져오는거
    public String home(){
        return "home";
    }
}
