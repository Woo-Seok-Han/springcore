package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용 되어야 한다")
    void vip_o(){
        //given
        Member member = new Member(1L, "vipMember", Grade.VIP);
        int price = 2000;

        //when
        int discountPrice = discountPolicy.discount(member, price);

        //then
        assertThat(discountPrice).isEqualTo(200);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용 되지 않아야 한다")
    void vip_x(){
        //given
        Member member = new Member(1L, "basicMember", Grade.BASIC);
        int price = 2000;

        //when
        int discountPrice = discountPolicy.discount(member, price);

        //then
        assertThat(discountPrice).isEqualTo(0);
    }

}