package com.example.board.Controller;

import com.example.board.Dto.BoardEditDto;
import com.example.board.Dto.BoardSaveDto;
import com.example.board.Entity.Board;
import com.example.board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //[게시물 등록]
    @PostMapping("/board/add")
    public Board addBoard(@RequestBody BoardSaveDto boardSaveDto) {
        String inputPassword = boardSaveDto.getPassword();
        String reg = "^(?=.*\\d)[A-Za-z0-9]{6,}$";

        if(Pattern.matches(reg, inputPassword)) {
            return boardService.addBoard(boardSaveDto);
        }
        return null;
    }

    //[게시물 삭제]
    @DeleteMapping("/board/delete/{id}/{password}")
    public Board delete(@PathVariable("id") Long id, @PathVariable("password") String password) {
        return boardService.delete(id, password);
    }

    //[게시물 수정]
    @PutMapping("/board/update/{password}")
    public BoardEditDto updateBoard(@RequestBody BoardEditDto boardEditDto, @PathVariable("password") String password) {
        boardService.edit(boardEditDto, password);
        return boardEditDto;
    }
}
