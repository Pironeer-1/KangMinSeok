package com.pironeer.templateCode.member.service;

import com.pironeer.templateCode.global.dto.response.JwtTokenSet;
import com.pironeer.templateCode.global.dto.response.result.ResponseData;
import com.pironeer.templateCode.global.exception.ErrorCode;
import com.pironeer.templateCode.global.service.AuthService;
import com.pironeer.templateCode.global.service.ResponseService;
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
    private final AuthService authService;

    public ResponseData<JwtTokenSet> register(MemberRequest request){
        if(memberRepository.existsByMemberId(request.memberId())) {
            throw new RuntimeException(ErrorCode.USER_ALREADY_EXIST.getMessage());
        }

        Member member = memberRepository.save(MemberMapper.from(request));
        JwtTokenSet token = authService.generateToken(member);
        return ResponseService.getResponseData(token);
    }

    public ResponseData<JwtTokenSet> login(MemberRequest request){
        Member member = memberRepository.findByMemberId(request.memberId())
                .orElseThrow(() -> new RuntimeException(ErrorCode.USER_NOT_EXIST.getMessage()));
        if(!member.getPassword().equals(request.password())){
            throw new RuntimeException(ErrorCode.USER_WRONG_PASSWORD.getMessage());
        }
        JwtTokenSet token = authService.generateToken(member);
        return ResponseService.getResponseData(token);
    }
}
