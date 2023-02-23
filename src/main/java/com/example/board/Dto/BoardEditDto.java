package com.example.board.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardEditDto {
    private Long id;
    private String password;
    private String title;
    private String content;

    @Builder
    public BoardEditDto(Long id, String password, String title, String content) {
        this.id = id;
        this.password = password;
        this.title = title;
        this.content = content;
    }

}
