package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 가입, 회원 찾기를 위한 회원저장소 필요
    // 추상과 구체화에 둘다 의존하고 있다. (dip 위반)
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
