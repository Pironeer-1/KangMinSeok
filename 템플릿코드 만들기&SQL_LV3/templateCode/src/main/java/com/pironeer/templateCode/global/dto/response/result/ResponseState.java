package com.pironeer.templateCode.global.dto.response.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseState {

    SUCCESS("성공하셨습니다."),
    FAIL("실패하셨습니다.");

    private String message;

}
