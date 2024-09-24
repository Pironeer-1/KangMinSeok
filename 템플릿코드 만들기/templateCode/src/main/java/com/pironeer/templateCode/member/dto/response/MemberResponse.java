package com.pironeer.templateCode.member.dto.response;

import com.pironeer.templateCode.member.dto.request.CreateMemberRequest;

public record MemberResponse(String memberId, String password, String name) {
    public static CreateMemberRequest of(String MemberId, String password, String name) {
        return new CreateMemberRequest(MemberId, password, name);
    }
}
