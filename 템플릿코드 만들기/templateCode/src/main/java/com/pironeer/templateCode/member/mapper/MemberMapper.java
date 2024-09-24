package com.pironeer.templateCode.member.mapper;

import com.pironeer.templateCode.member.dto.request.MemberRequest;
import com.pironeer.templateCode.member.entity.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class MemberMapper {
    public static Member from(MemberRequest request){
        return Member.builder()
                .memberId(request.memberId())
                .password(request.password())
                .name(request.name())
                .build();
    }
}
