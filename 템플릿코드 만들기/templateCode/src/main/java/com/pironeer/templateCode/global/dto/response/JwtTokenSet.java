package com.pironeer.templateCode.global.dto.response;

import com.pironeer.templateCode.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JwtTokenSet <member> {
    private String token;
    private Member member;
}
