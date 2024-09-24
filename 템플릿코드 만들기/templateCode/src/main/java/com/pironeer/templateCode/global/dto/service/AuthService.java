package com.pironeer.templateCode.global.dto.service;

import com.pironeer.templateCode.global.dto.response.JwtTokenSet;
import com.pironeer.templateCode.global.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtUtil jwtUtil;

    public JwtTokenSet generateToken(Long userId) {

    }
}
