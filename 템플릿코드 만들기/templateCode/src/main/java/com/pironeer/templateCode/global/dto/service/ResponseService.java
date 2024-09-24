package com.pironeer.templateCode.global.dto.service;


import com.pironeer.templateCode.global.dto.response.result.ResponseData;
import org.springframework.stereotype.Component;

@Component
public class ResponseService {
    public static <T> ResponseData<T> getResponseData(T data) {
        ResponseData<T> result = new ResponseData<>();
        result.setData(data);
        return result;
    }
}
