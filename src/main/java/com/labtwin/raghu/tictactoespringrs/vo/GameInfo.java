package com.labtwin.raghu.tictactoespringrs.vo;

import com.labtwin.raghu.tictactoespringrs.exceptions.InvalidMoveException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter @Setter
public class GameInfo {

    public Integer gameId;
    public Boolean gameOver;
    public Map<String, String> board;

    public GameInfo(Integer gameId) {
        this.board = new HashMap<>();
        this.board.put("0", null);
        this.board.put("1", null);
        this.board.put("2", null);
        this.board.put("3", null);
        this.board.put("4", null);
        this.board.put("5", null);
        this.board.put("6", null);
        this.board.put("7", null);
        this.board.put("8", null);
        this.board.put("9", null);
        this.gameId=gameId;
        this.gameOver = false;
    }


}
