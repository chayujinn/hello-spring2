package hello2.hellospring2.controller;

import hello2.hellospring2.domain.Member;
import hello2.hellospring2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired//Controller와 Service를 연결한다
    public MemberController(MemberService memberService) { //Alt+insert 생성자
         this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";//리턴한 곳 templates의 members/createMemberForm으로 이동
    }
    //templates에 Directory로 members만들기

    @PostMapping("/members/new")//데이터를 폼에 넣어서 전달할때 Post방식
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());//form에서 getName으로 꺼내서

        memberService.join(member);//join으로 멤버를 넘긴다(member가 가입이 된거임)

        return "redirect:/";//회원가입이 끝났으니 홈화면으로 보내버린다
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();//memberService.findMembers();상태에서 Ctrl+Alt+V 눌러서 변수 추출
        model.addAttribute("members",members);//멤버리스트 자체를 모델에 담아서 화면에 넘긴다
        return "members/memberList";
    }
}
