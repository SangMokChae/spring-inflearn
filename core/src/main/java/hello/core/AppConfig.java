package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // 여기서 생성자 주입 MemoryMemberRepository를 주입해준다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // ctrl + alt + m 중복되는 것들도 한번에 바꾸어 준다.
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    // 나중에 바꿀때 위의 코드만 변경해주면 된다.

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
} // 설계도에 가장 유사하게 만드는게 좋다. // 구성 파악이 쉽다. // 중복 제거
