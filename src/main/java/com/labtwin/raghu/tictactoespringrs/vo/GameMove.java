package com.labtwin.raghu.tictactoespringrs.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameMove {

    private Integer gameId;
    private Integer postion;
    private Players playerId;


}
