package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

// 요구 사항 할인 정책을 구현함 ( 고정 할인 )
// 회원의 등급이 vip 일시, 고정 할인 금액 1000원
// 회원의 등급이 vip 가 아닐시, 고정 할인 금액 0원
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        // enum 의 경우 == 연사자로 비교한다
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
