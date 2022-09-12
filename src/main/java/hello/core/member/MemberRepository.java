package hello.core.member;

// 역할과 구현을 분리하자
// 요구 사항 : 저장소가 in-memory, DB, 외부 저장소 가 될 수 있다
// MemberRepository 의 역할은 저장소 interface 로 구성한다
public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
