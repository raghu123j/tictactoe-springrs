package com.labtwin.raghu.tictactoespringrs.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class GameVO {

    private Integer userId;


    public GameVO(int gameId){
        this.gameId=gameId;
    }

    private Integer gameId;
    private String move;

}
