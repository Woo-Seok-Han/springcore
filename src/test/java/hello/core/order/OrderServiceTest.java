package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    //given
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        String itemName = "자전거";
        int itemPrice = 2000;

        //when
        // 회원이 가입
        // 회원이 주문
        // 할인 정책에 따른 할인 후 주문 반환
        memberService.join(member);
        Member joinedMember = memberService.findMember(member.getId());
        Order order = orderService.createOrder(joinedMember.getId(), itemName, itemPrice);

        //then
        // 회원 등급에 따라 할인이 되었는지 확인
        // vip 일시 itemPrice - discountPrice = 1000
        System.out.println("order = " + order);
        assertThat(order.getDiscountPrice()).isEqualTo(200);
    }
}
