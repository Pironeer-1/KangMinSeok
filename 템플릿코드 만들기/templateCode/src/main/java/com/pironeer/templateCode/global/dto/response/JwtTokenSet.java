package com.pironeer.templateCode.global.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JwtTokenSet {
    private String token;
    private String grantType;
}
