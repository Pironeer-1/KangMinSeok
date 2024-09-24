package com.pironeer.templateCode.member.dto.response;

import com.pironeer.templateCode.member.dto.request.MemberRequest;
import com.pironeer.templateCode.member.entity.Member;

public record MemberResponse(String memberId, String password, String name) {
    public static MemberResponse of(Member member) {
        return new MemberResponse(member.getMemberId(), member.getPassword(), member.getName());
    }
}
