package com.pironeer.week2.dto.request;

import java.time.LocalDateTime;

public record CommentCreateRequest(//댓글 고유 id
        String content, //댓글 내용
        Long parentId // 대댓글 대상 id
) {
}
