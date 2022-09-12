package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

//Junit 테스트 코드 작성
public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    @Test
    void join(){

        //given
        // 추가할 회원을 정의한다
        Member member = new Member(1L, "memeberA", Grade.VIP);

        //when
        // 회원을 추가한다
        // 추가한 회원을 조회한다
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        //then
        // 조회한 회원과 초기에 추가할 회원을 비교한다
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
