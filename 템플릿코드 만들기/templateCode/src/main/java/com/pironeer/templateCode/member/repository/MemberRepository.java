package com.pironeer.templateCode.member.repository;

import com.pironeer.templateCode.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    public Member save(Member member);
    public Optional<Member> findById(long id);
    public Optional<Member> findByMemberId(String memberId);
    public boolean existsByMemberId(String memberId);
    public List<Member> findAll();

}
