package com.pironeer.templateCode.board.service;

import com.pironeer.templateCode.board.dto.request.BoardRequest;
import com.pironeer.templateCode.board.dto.response.BoardResponse;
import com.pironeer.templateCode.board.entity.Board;
import com.pironeer.templateCode.board.mapper.BoardMapper;
import com.pironeer.templateCode.board.repository.BoardRepository;
import com.pironeer.templateCode.global.dto.response.result.ListResponseData;
import com.pironeer.templateCode.global.dto.response.result.ResponseData;
import com.pironeer.templateCode.global.exception.ErrorCode;
import com.pironeer.templateCode.global.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public ResponseData<Board> createBoard(BoardRequest request) {
            Board board = boardRepository.createBoard(BoardMapper.from(request));
            return ResponseService.getResponseData(board);
    }

    public ResponseData<BoardResponse> findBoardById(Long id) {
        Board board = boardRepository.findBoardById(id)
                .orElseThrow(() -> new RuntimeException(ErrorCode.BOARD_NOT_FOUND.getMessage()));
        BoardResponse response = BoardResponse.of(board);
        return ResponseService.getResponseData(response);
    }

    public ListResponseData<BoardResponse> findBoardByMemberId(String memberId) {
        List<Board> boards = boardRepository.findBoardByMemberId(memberId);
        List<BoardResponse> list = boards.stream().map(BoardResponse::of).toList();
        return ResponseService.getListResponseData(list);
    }

    public Long deleteById(Long boardId) {
        Long deleteId = boardRepository.deleteBoardById(boardId);
        return deleteId;
    }
}
