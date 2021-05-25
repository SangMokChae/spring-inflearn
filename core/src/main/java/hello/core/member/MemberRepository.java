package hello.core.member;

public interface MemberRepository { // 회원 저장소

    // 회원을 저장
    void save(Member member);

    // 회원 아이디를 찾는 것
    Member findById(Long memberId);
}
// 가능한 인터페이스와 구현페이지를 다른 위치에 두는게 설계상 좋다.
