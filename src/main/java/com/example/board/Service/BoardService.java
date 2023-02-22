package com.example.board.Service;


import com.example.board.Dto.BoardSaveDto;
import com.example.board.Entity.Board;
import com.example.board.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
