package com.example.board.Service;


import com.example.board.Dto.BoardSaveDto;
import com.example.board.Entity.Board;
import com.example.board.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    //[게시물 등록]
    @Transactional
    public Board addBoard(BoardSaveDto boardSaveDto) {
        Board board = new Board(boardSaveDto);
        return boardRepository.save(board);
    }

    //[게시물 삭제]
    @Transactional
    public Board delete(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 게시물이 존재하지 않습니다. id = " +id));
        if(equals(board.getPassword())) {
            boardRepository.delete(board);
            return board;
        } else throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
    }

}
