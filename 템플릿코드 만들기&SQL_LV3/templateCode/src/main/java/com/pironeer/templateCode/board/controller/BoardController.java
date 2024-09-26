package com.pironeer.templateCode.board.controller;

import com.pironeer.templateCode.board.dto.request.BoardRequest;
import com.pironeer.templateCode.board.dto.response.BoardResponse;
import com.pironeer.templateCode.board.entity.Board;
import com.pironeer.templateCode.board.service.BoardService;
import com.pironeer.templateCode.global.dto.response.SuccessResponse;
import com.pironeer.templateCode.global.dto.response.result.ListResponseData;
import com.pironeer.templateCode.global.dto.response.result.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public SuccessResponse<ResponseData<Board>> create(@RequestBody BoardRequest request) {
        ResponseData<Board> response = boardService.createBoard(request);
        return SuccessResponse.ok(response);
    }

    @GetMapping("/{boardId}")
    public SuccessResponse<ResponseData<BoardResponse>> findBoardById(@PathVariable("boardId") Long boardId) {
        ResponseData<BoardResponse> response = boardService.findBoardById(boardId);
        return SuccessResponse.ok(response);
    }

    @GetMapping("/find/{memberId}")
    public SuccessResponse<ListResponseData<BoardResponse>> findBoardByMemberId(@PathVariable("memberId") String memberId) {
        ListResponseData<BoardResponse> response = boardService.findBoardByMemberId(memberId);
        return SuccessResponse.ok(response);
    }
    @PostMapping("/{boardId}")
    public ResponseEntity<Long> deleteByBoardId(@PathVariable("boardId") Long boardId) {
        Long deleteId = boardService.deleteById(boardId);
        return ResponseEntity.ok().body(deleteId);
    }
}
