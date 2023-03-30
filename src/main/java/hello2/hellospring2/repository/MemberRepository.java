//저장소

package hello2.hellospring2.repository;

import hello2.hellospring2.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {//4가지 기능
    Member save(Member member);//save하면 회원 저장소에 저장됨
    Optional<Member> findById(Long id);//Id로 회원을 찾는거
    Optional<Member> findByName(String name);//Optional은 감싸는 용도?
    List<Member>findAll();//findAll로 저장된 모든 회원 반환

}
