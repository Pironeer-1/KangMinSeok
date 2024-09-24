package com.pironeer.templateCode.global.dto.response.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResponseData<T> {
    private List<T> list;
}
