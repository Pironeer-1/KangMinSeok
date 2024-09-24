package com.pironeer.templateCode.board.dto.request;

import jakarta.validation.constraints.NotBlank;

public record BoardRequest(
        @NotBlank
        String memberId,
        @NotBlank
        String title,
        @NotBlank
        String content
) {
}
