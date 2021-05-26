package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    // 메모리 회원 저장소, 고정환율 정책
    // final은 무조건 할당을 하게끔 만든다. 기본할당// 생성자 할당
    // 인터페이스에만 의존중이다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override // 주문생성 발생시
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원과 할인가 적용
        Member member = memberRepository.findById(memberId); // 1. 회원조회(grade만 넘길수 있음)
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인정책 적용

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
