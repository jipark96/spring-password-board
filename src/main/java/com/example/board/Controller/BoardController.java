package com.example.board.Controller;

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

    @PostMapping("/board/add")
    public Board addBoard(@RequestBody BoardSaveDto boardSaveDto) {
        String inputPassword = boardSaveDto.getPassword();
        String reg = "^(?=.*\\d)[A-Za-z0-9]{6,}$";

        if(Pattern.matches(reg, inputPassword)) {
            return boardService.addBoard(boardSaveDto);
        }
        return null;
    }

    @DeleteMapping("/board/delete/{id}")
    public Board delete(@PathVariable("id") Long id) {
        return boardService.delete(id);
    }
}
