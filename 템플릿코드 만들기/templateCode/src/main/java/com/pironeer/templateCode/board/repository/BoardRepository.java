package com.pironeer.templateCode.board.repository;

import com.pironeer.templateCode.board.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    public Board createBoard(Board board);
    public Optional<Board> findBoardById(Long id);
    public List<Board> findBoardByMemberId(String memberId);
    public boolean existBoardByMemberId(String memberId);
    public Long deleteBoardById(Long id);
}
