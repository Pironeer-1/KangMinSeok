package com.pironeer.week2.repository.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id; //댓글 고유 id
    private String content; //댓글 내용
    private Long topicId; // 댓글 단 topic
    private Long parentId; // 대댓글 대상 id
    private LocalDateTime createdCommentAt; // 댓글 작성 시간

    @Builder
    public Comment(Long id, String content, Long topicId, Long parentId, LocalDateTime createdCommentAt) {
        this.id = id;
        this.content = content;
        this.topicId = topicId;
        this.parentId = parentId;
        this.createdCommentAt = createdCommentAt;
    }
}
