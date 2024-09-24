package com.pironeer.templateCode.global.service;


import com.pironeer.templateCode.global.dto.response.result.ListResponseData;
import com.pironeer.templateCode.global.dto.response.result.ResponseData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseService {
    public static <T> ResponseData<T> getResponseData(T data) {
        ResponseData<T> result = new ResponseData<>();
        result.setData(data);
        return result;
    }
    public static <T> ListResponseData<T> getListResponseData(List<T> list) {
        ListResponseData<T> result = new ListResponseData<>();
        result.setList(list);
        return result;
    }
}
