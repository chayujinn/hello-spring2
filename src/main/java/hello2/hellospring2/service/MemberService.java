package hello2.hellospring2.service;

import hello2.hellospring2.domain.Member;
import hello2.hellospring2.repository.MemberRepository;
import hello2.hellospring2.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     *회원가입dddd
     */
        public Long join(Member member) {
            //같은 이름이 있는 중복회원X
            validateEuplicateMember(member);//중복회원 검증

            memberRepository.save(member);
            return member.getId();
        }

    private void validateEuplicateMember(Member member) {
        memberRepository.findByName(member.getName())//단축키 ctrl + alt + v 변수추출
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다."); //메소드 만들기 ctrl+alt+shift+T한 후,method 검색
        });
    }

    /**
     *전체 회원 조회
     */

    public List<Member> findMembers(){
            return memberRepository.findAll();
    }
    public Optional<Member>findOne(Long memberId){
            return memberRepository.findById(memberId);
    }

}
