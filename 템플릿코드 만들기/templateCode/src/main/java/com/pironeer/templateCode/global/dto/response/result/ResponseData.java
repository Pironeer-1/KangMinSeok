package com.pironeer.templateCode.global.dto.response.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData<T> {

    private T data;
}
