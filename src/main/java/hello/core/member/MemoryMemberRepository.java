package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// in-memory 저장소 구현체 ( 테스트 용 )
// 저장소 저장
// 저장소 조회
public class MemoryMemberRepository implements MemberRepository{

    // 실무에서는 concurrency hashmap 을 사용 ( 동시성 이슈 )
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
