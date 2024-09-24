package com.pironeer.templateCode.member.dto.request;

public record CreateMemberRequest(String MemberId, String password, String name) {

    public CreateMemberRequest of(String MemberId, String password, String name) {
        return new CreateMemberRequest(MemberId, password, name);
    }
}
