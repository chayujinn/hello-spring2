package hello2.hellospring2.service;

import hello2.hellospring2.domain.Member;
import hello2.hellospring2.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


//간단하게 테스트 하는 방법 단축키:shift+Ctrl+T
//자동으로 껍데기 만들어짐

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;


    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach// Test 하나씩 끝날때마다 clear됨
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test//테스트는 한글로 써도 됨
    void 회원가입() {
        //given   상황이 주어졌을때
        Member member = new Member();
        member.setName("hello");

        //when    이거를 실행을 했을때
        Long saveId = memberService.join(member);

        //then    결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());//멤버 이름이 findMember의 이름과 같은지 확인
        //static import로 변경하려면 Alt+Enter해서 두번째꺼 누름
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();//Shift+F6 한꺼번에 변수이름 바꾸기
        member2.setName("spring");

        
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
         assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}