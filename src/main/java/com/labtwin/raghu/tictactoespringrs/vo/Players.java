package com.labtwin.raghu.tictactoespringrs.vo;

public enum Players {
    X,
    O;

    private Players getPlayer(String val){
        return Players.valueOf(val);
    }

}
