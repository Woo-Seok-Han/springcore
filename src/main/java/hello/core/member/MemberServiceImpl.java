package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 회원 서비스 구현체
// 회원 가입
// 회원 조회
@Component
public class MemberServiceImpl implements MemberService{
// interface 가 한개만 존재할 경우 구현체 클래스 명은 관례상 interface 이름 뒤에 impl 을 붙인다

    private final MemberRepository memberRepository;

    // 생성자가 한개 일시에는 Autowired 자동 생성
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
