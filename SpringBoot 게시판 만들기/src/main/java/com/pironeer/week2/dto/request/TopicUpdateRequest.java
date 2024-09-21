package com.pironeer.week2.dto.request;

import java.time.LocalDateTime;

public record TopicUpdateRequest(Long id, String title, String content) {
}
