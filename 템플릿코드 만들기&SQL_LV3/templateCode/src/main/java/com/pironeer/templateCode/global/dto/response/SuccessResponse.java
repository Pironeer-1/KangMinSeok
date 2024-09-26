package com.pironeer.templateCode.global.dto.response;

import com.pironeer.templateCode.global.dto.response.result.ResponseState;
import lombok.Getter;

@Getter
public class SuccessResponse <T>{

    private String message;
    private T result;

    public SuccessResponse(String message, T data) {
        this.message = message;
        this.result = data;
    }

    public static <T> SuccessResponse<T> of (String message, T data){
        return new SuccessResponse<> (message, data);
    }

    public static <T> SuccessResponse<T> ok(T data) {
        return of(ResponseState.SUCCESS.getMessage(), data);
    }
}
