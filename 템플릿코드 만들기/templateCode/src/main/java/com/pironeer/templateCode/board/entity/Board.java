package com.pironeer.templateCode.board.entity;

import lombok.Builder;
import lombok.Data;

@Data
public class Board {
    private Long id;
    private String memberId; // 작성자
    private String title; // 제목
    private String content; // 내용

    @Builder
    public Board(String memberId, String title, String content) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
    }
}
