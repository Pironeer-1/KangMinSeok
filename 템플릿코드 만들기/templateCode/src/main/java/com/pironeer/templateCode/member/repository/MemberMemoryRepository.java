package com.pironeer.templateCode.member.repository;

import com.pironeer.templateCode.member.entity.Member;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberMemoryRepository implements MemberRepository {
    private final AtomicLong memberIdxGenerator = new AtomicLong(0);
    private final Map<Long, Member> memberMap = new HashMap<>();

    public Member save(Member member) {
        if (member.getMemberId() == null) { // 새로 생성
            Long id = memberIdxGenerator.getAndIncrement();
            memberMap.put(id, member);
            member.setId(id);
            return member;
        }else{ // 이미 존재 -> 수정
            memberMap.replace(member.getId(), member);
            return member;
        }
    }

    public Optional<Member> findById(long id) { // pk로 멤버 조회
        Assert.notNull(id, "id must not be null");
        return Optional.ofNullable(memberMap.get(id));
    }

    public Optional<Member> findByMemberId(String memberId) { // id로 멤버 조회
        return memberMap.values().stream()
                .filter(mbr -> mbr.getMemberId().equals(memberId))
                .findAny();
    }

    public boolean existsByMemberId(String memberId) { // 멤버가 존재하는지 확인
        return memberMap.values().stream()
                .anyMatch(mbr -> mbr.getMemberId().equals(memberId));
    }
}
