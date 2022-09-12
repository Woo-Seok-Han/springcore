package hello.core;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//DI 란 ?
//어플리케이션 실행 시점(런타임)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와
//서버의 실제 의존 관계가 연결되는 것을 의존 관계 주입 이라고 한다
//
//객체 인스턴스를 생성하고, 참조 값을 통해 연결 된다.
//클라이언트 코드를 변경 하지 않고 클라이언트가 호출하는 대상의 타입 인스턴스를 변경 할 수 있다.


// 다른 구현체로 변경할 때 한 부분만 변경하면 된다
// AppConfig 를 보면 역할과 구현 클래스가 한눈에 들어온다
public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
