package com.pironeer.templateCode.global.service;

import com.pironeer.templateCode.global.dto.response.JwtTokenSet;
import com.pironeer.templateCode.global.jwt.JwtUtil;
import com.pironeer.templateCode.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtUtil jwtUtil;

    public JwtTokenSet generateToken(Member member) { // 토큰 생성 메소드
        String token = jwtUtil.createToken(member.getId());
        JwtTokenSet jwtTokenSet = JwtTokenSet.builder()
                .token(token)
                .member(member)
                .build();

        return jwtTokenSet;
    }
}
