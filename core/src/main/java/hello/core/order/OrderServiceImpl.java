package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // 메모리 회원 저장소, 고정환율 정책
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override // 주문생성 발생시
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원과 할인가 적용
        Member member = memberRepository.findById(memberId); // 1. 회원조회(grade만 넘길수 있음)
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인정책 적용

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
