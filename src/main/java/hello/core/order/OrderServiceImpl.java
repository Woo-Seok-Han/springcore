package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.stereotype.Component;

// 구현
// 주문 생성
@Component
public class OrderServiceImpl implements OrderService{

    MemberRepository memberRepository;
    DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 단일 체계 원칙이 잘 지켜짐
    // -> 할인 체계를 몰라도 discountPolicy 만 있으면 할인적용 후 주문 생성이 가능하다
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원을 조회한다
        // 할인 정책에 할인 여부 판단을 위임한다
        // 할인된 금액에 대한 주문 정보를 반환한다
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
