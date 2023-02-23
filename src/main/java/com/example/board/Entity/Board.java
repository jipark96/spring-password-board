package com.example.board.Entity;

import com.example.board.Dto.BoardEditDto;
import com.example.board.Dto.BoardSaveDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@ToString
@RequiredArgsConstructor
@Data
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(length = 20)
    private String title;

    @Column(length = 200)
    private String content;

    @Column
    private String password;

    @Column
    private String weather;

    @Column
    private LocalDateTime createdTime;

    @Column
    private LocalDateTime updatedTime;


    @Builder
    public Board(BoardSaveDto boardSaveDto) {
        this.title = boardSaveDto.getTitle();
        this.content = boardSaveDto.getContent();
        this.password = boardSaveDto.getPassword();
        this.weather = boardSaveDto.getWeather();
    }

    @Builder
    public Board(BoardEditDto boardEditDto) {
        this.id = boardEditDto.getId();
        this.password = boardEditDto.getPassword();
        this.title = boardEditDto.getTitle();
        this.content = boardEditDto.getContent();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

