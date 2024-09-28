package com.pironeer.templateCode.member.mapper;

import com.pironeer.templateCode.member.dto.request.MemberRequest;
import com.pironeer.templateCode.member.entity.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

public class MemberMapper {
     //static 메소드를 통해 객체를 생성하지 않고도 메소드를 사용할 수 있다
    public static Member from(MemberRequest request){
        return Member.builder()
                .memberId(request.memberId())
                .password(request.password())
                .name(request.name())
                .build();
    }
}
