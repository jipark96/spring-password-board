package com.example.board.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardSaveDto {

    private String title;
    private String content;
    private String password;
    private String weather;

    @Builder
    public BoardSaveDto(String title, String content, String password, String weather) {
        this.title = title;
        this.content = content;
        this.password = password;
        this.weather = weather;
    }
}
