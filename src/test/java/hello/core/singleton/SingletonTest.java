package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){

        AppConfig appConfig = new AppConfig();

        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 호출 시에 계속 다른 객체가 생성된다
        // 웹 어플리케이션의 경우 사용자가 매우 많아 50000개의 객체 생성 등은 효율적이지 않다
        // => 메모리 낭비가 심하다
        assertThat(memberService1).isNotSameAs(memberService2);

        // => 해당 객체가 딱 1개만 생성되고, 공유하도록 설계한다 = 싱글톤 패턴
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        assertThat(singletonService1).isSameAs(singletonService2);
        // same == java 의 == 비교와 동일
        // equal == java의 .equals 와 동일

        // 스프링 컨테이너로 빈 생성 시에 모든 객체들을 싱글톤으로 관리해준다
    }
}
