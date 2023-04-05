package hello2.hellospring2.service;

import hello2.hellospring2.domain.Member;
import hello2.hellospring2.repository.MemberRepository;
import hello2.hellospring2.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {            //간단하게 테스트 하는 방법 단축키:shift+Ctrl+T

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {//alter+insert 생성자 만들어줌

        this.memberRepository = memberRepository;
    }

    /**회원가입**/
        public Long join(Member member) {
            //같은 이름이 있는 중복회원X
            validateDuplicateMember(member);//중복회원 검증
             memberRepository.save(member);//통과하면 저장
            return member.getId();
        }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())//단축키 ctrl + alt + v 변수추출
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다."); //메소드 만들기 ctrl+alt+shift+T한 후,Extract Method 검색
        });
    }

    /**
     *전체 회원 조회
     */

    public List<Member> findMembers() {
            return memberRepository.findAll();
    }
    public Optional<Member>findOne(Long memberId){
            return memberRepository.findById(memberId);
    }

}
