package com.pironeer.templateCode.member.service;

import com.pironeer.templateCode.global.dto.response.JwtTokenSet;
import com.pironeer.templateCode.global.dto.response.SuccessResponse;
import com.pironeer.templateCode.member.dto.request.MemberRequest;
import com.pironeer.templateCode.member.dto.response.MemberResponse;
import com.pironeer.templateCode.member.entity.Member;
import com.pironeer.templateCode.member.mapper.MemberMapper;
import com.pironeer.templateCode.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SuccessResponse<JwtTokenSet> register(MemberRequest request){
        if(memberRepository.existsByMemberId(request.memberId())) {
            throw new RuntimeException("ALREADY EXISTS MEMBER");
        }

        Member member = memberRepository.save(MemberMapper.from(request));

        return MemberResponse.of(member);
    }

    public MemberResponse findById(Long id){
        Member member = memberRepository.findById(id).orElse(null);
        return MemberResponse.of(member);
    }

    public MemberResponse findByMemberId(String memberId){
        Member member = memberRepository.findByMemberId(memberId).orElse(null);
        return MemberResponse.of(member);
    }

    public List<MemberResponse> findAll(){
        List<Member> members = memberRepository.findAll();
        return members.stream().map(MemberResponse::of).toList();
    }
}
