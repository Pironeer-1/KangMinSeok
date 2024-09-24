package com.pironeer.templateCode.member.service;

import com.pironeer.templateCode.member.dto.request.MemberRequest;
import com.pironeer.templateCode.member.dto.response.MemberResponse;
import com.pironeer.templateCode.member.entity.Member;
import com.pironeer.templateCode.member.mapper.MemberMapper;
import com.pironeer.templateCode.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberResponse save(MemberRequest request){

        memberRepository.save(memberMapper);
    }
}
