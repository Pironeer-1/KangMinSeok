package com.pironeer.templateCode.board.dto.response;

import com.pironeer.templateCode.board.entity.Board;

public record BoardResponse(String memberId, String title, String content) {
    public static BoardResponse of(Board board) {
        return new BoardResponse(board.getMemberId(), board.getTitle(), board.getContent());
    }
}
