package com.pironeer.week2.dto.response;

import com.pironeer.week2.repository.domain.Comment;
import com.pironeer.week2.repository.domain.Topic;

import java.time.LocalDateTime;

public record CommentResponse(Long id, //댓글 고유 id
                              String content, //댓글 내용
                              Long topicId, // topic 아이디,
                              Long parentId, //대댓글을 단 댓글의 id
                              LocalDateTime createdCommentAt ) {
    public static CommentResponse of(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getContent(), comment.getTopicId(), comment.getParentId(), comment.getCreatedCommentAt());
    }
}
