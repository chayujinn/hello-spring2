package hello2.hellospring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //주소창에서 localhost:8080/hello칠때 그 hello
    public String hello(Model model){ //MVC-model,view,controller에서 그 model
        model.addAttribute("data","hello!!");// hello.html에서 data값을 hello!!로 치환
        return "hello"; //resources안에 templates에서  파일명(View name)이 hello인거 연결!
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name,Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")//문자 내놓을때
    @ResponseBody //http에서 body부에 아래 데이터를 직접 넣어주겠다라는 말
    public String helloString(@RequestParam("name")String name){

        return "hello" + name; //name에 spring 넣으면 그대로 들어감//주소창에 쓰면 그대로
    }

    @GetMapping("hello-api")//데이터 내놓으라고 할때//API방식!!
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();//shift+ctrl+enter 자동완성 단축키
        hello.setName(name);
        return hello; //주소창 localhost/hello-api?name=spring!!! 하면 결과값 {"name":"spring!!!"}json방식(키:밸류)으로 나옴
    }

    static class Hello {

        private String name;//키

        //property 접근방식이라고도 함
        public String getName() {//꺼낼때 getter setter Alt+insert 단축키
            return name;
        }

        public void setName(String name) {//넣을때
            this.name = name;
        }
    }

}