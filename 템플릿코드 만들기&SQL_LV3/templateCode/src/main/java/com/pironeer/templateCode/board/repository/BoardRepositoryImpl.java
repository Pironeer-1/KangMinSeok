package com.pironeer.templateCode.board.repository;

import com.pironeer.templateCode.board.entity.Board;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

    private final AtomicLong boardIdxGenerator = new AtomicLong(0);
    private final Map<Long, Board> boardMap = new HashMap<>();

    public BoardRepositoryImpl() {
        Board board1 = new Board("123", "456", "789");
        Board board2 = new Board("123", "asd", "zxc");
        boardMap.put(boardIdxGenerator.incrementAndGet(), board1);
        boardMap.put(boardIdxGenerator.incrementAndGet(), board2);
    }

    @Override
    public Board createBoard(Board board) {
        if(board.getId() == null){
            Long id = boardIdxGenerator.incrementAndGet();
            board.setId(id);
            boardMap.put(id, board);
            return board;
        }else{
            boardMap.replace(board.getId(), board);
            return board;
        }
    }

    @Override
    public Optional<Board> findBoardById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.ofNullable(boardMap.get(id));
    }

    @Override
    public List<Board> findBoardByMemberId(String memberId) {
        return boardMap.values().stream()
                .filter(board -> board.getMemberId().equals(memberId))
                .toList();
    }

    @Override
    public boolean existBoardByMemberId(String memberId) {
        return boardMap.values().stream()
                .anyMatch(board -> board.getMemberId().equals(memberId));
    }


    @Override
    public Long deleteBoardById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        boardMap.remove(id);
        return id;
    }
}
