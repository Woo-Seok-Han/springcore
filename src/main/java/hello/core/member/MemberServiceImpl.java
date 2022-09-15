package hello.core.member;

// 회원 서비스 구현체
// 회원 가입
// 회원 조회
public class MemberServiceImpl implements MemberService{
// interface 가 한개만 존재할 경우 구현체 클래스 명은 관례상 interface 이름 뒤에 impl 을 붙인다


    private final MemberRepository memberRepository;

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
