package hello2.hellospring2.repository;

import hello2.hellospring2.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{ //implements methods 눌러서 전부 다 선택하면 오버라이드 자동

    private static Map<Long,Member>store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {//save를 할때 어딘가에 저장을 해야함 그게 Map임
        member.setId(++sequence);//Id 세팅 먼저하고
        store.put(member.getId(),member);//store에 저장하면 Map에 저장됨
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));//Null이여도 Optional로 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
