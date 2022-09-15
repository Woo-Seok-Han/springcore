package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    public void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //구체 타입으로 꺼내면 좋지 않음
        // 테스트 용도로 구현체에 만든 메서드를 호출하기 위함
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = ac.getBean("memberRepository", MemberRepository.class);
        MemberRepository memberRepository2 = memberService.getMemberRepository();
        MemberRepository memberRepository3 = orderService.getMemberRepository();

        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository3 = " + memberRepository3);

        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(memberRepository1).isSameAs(memberRepository3);
    }

    @Test
    public void configurationDeep() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean("appConfig", AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
    }
}
