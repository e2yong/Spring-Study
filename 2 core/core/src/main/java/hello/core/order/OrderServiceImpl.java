package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy;
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 정보 검색
        Member member = memberRepository.findById(memberId);
        // 등급 확인하고 할인 금액 확인
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 주문 생성해서 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
