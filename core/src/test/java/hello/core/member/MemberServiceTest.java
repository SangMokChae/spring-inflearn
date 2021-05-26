package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach // Test 실행전에 무조건 먼저 실행
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    // Test 실행전에 AppConfig가 memberServic를 먼저 할당해주고 Test가 돌아가게 된다.

    @Test
    void join() {
        // given (이런 환경에서..)
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when (이렇게 주어졌을때..)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then (이렇게 된다!)
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
