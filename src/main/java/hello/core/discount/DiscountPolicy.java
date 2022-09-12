package hello.core.discount;

import hello.core.member.Member;

// 할인 정책 역할 정의
// 요구 사항 : 고정 할인, 변액 할인
public interface DiscountPolicy {

    int discount(Member member, int price);
}
