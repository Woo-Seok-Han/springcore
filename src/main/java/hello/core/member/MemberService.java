package hello.core.member;

// 회원 서비스 역할 정의
// 요구 사항 : 회원 가입, 회원 조회
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
