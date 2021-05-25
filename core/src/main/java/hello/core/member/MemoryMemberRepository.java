package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{ // Memory용

    //저장소에서 검색하기 위한 map
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

// 동시성 문제를 해결하기위해
// ConcurrentMap<k, v>를 사용하는 것이 좋다.