package com.pironeer.templateCode.member.controller;

import com.pironeer.templateCode.global.dto.response.JwtTokenSet;
import com.pironeer.templateCode.global.dto.response.SuccessResponse;
import com.pironeer.templateCode.global.dto.response.result.ResponseData;
import com.pironeer.templateCode.member.dto.request.MemberRequest;
import com.pironeer.templateCode.member.dto.response.MemberResponse;
import com.pironeer.templateCode.member.service.MemberService;
import jakarta.validation.Valid;
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
    public SuccessResponse<ResponseData<JwtTokenSet>> register(@Valid @RequestBody MemberRequest request){
        ResponseData<JwtTokenSet> result = memberService.register(request);
        return SuccessResponse.ok(result);
    }

    @PostMapping("/login")
    public SuccessResponse<ResponseData<JwtTokenSet>> login(@Valid @RequestBody MemberRequest request){
        ResponseData<JwtTokenSet> result = memberService.login(request);
        return SuccessResponse.ok(result);
    }

}
