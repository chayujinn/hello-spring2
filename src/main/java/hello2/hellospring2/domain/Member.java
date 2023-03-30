package hello2.hellospring2.domain;

public class Member {
    private Long id;//시스템에 저장하는 아이디 고객아이디 아님
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
