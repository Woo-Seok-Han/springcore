package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        //given
        AppConfig appConfig = new AppConfig();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

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

    }
}
