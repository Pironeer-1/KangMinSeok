package com.pironeer.templateCode.board.mapper;

import com.pironeer.templateCode.board.dto.request.BoardRequest;
import com.pironeer.templateCode.board.entity.Board;

public class BoardMapper {
    public static Board from(BoardRequest request){
        return Board.builder()
                .memberId(request.memberId())
                .title(request.title())
                .content(request.content())
                .build();
    }
}
