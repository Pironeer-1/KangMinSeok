package com.pironeer.templateCode.member.controller;

import com.pironeer.templateCode.member.dto.request.MemberRequest;
import com.pironeer.templateCode.member.dto.response.MemberResponse;
import com.pironeer.templateCode.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponse> register(@RequestBody MemberRequest request){
        MemberResponse response = memberService.register(request);
        return ResponseEntity.ok().body(response);
    }
}
