package com.labtwin.raghu.tictactoespringrs;

import com.labtwin.raghu.tictactoespringrs.exceptions.InvalidMoveException;
import com.labtwin.raghu.tictactoespringrs.vo.GameInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GamePlayService {

    private static final Logger logger = LogManager.getLogger(GamePlayService.class);

    public Boolean isGameOver(GameInfo gameInfo) {
        return gameInfo.gameOver;
    }

    public void endGame(Boolean gameOver,GameInfo gameInfo) {
        gameInfo.setGameOver(gameOver);
    }

    public void updateState(String position, String player,Map board) throws InvalidMoveException {
        if (board.get(position) != null) {
            logger.error("Exception, position already been taken");
            throw new InvalidMoveException("The position has already been taken");
        } //

        board.put(position, player);
        //find if winner exists
        checkWinner(board);
    }


    public String checkWinner(Map<String, String> board) {
        String result="";
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board.get("0") + board.get("1") + board.get("2");
                    break;
                case 1:
                    line = board.get("3") + board.get("4") + board.get("5");
                    break;
                case 2:
                    line = board.get("6") + board.get("7") + board.get("8");
                    break;
                case 3:
                    line = board.get("0") + board.get("3") + board.get("6");
                    break;
                case 4:
                    line = board.get("1") + board.get("4") + board.get("7");
                    break;
                case 5:
                    line = board.get("2") + board.get("5") + board.get("8");
                    break;
                case 6:
                    line = board.get("0") + board.get("4") + board.get("8");
                    break;
                case 7:
                    line = board.get("2") + board.get("4") + board.get("6");
                    break;
            }
            if (line.equals("XXX")) {
                result= "X";
            } else if (line.equals("OOO")) {
                result= "O";
            }
        }
        if(board.values().stream().filter(Objects::nonNull).count() == 8) {
            result= "draw";
        }
        logger.info("Status/Winner of the game is "+result);
        return result;


    }

}
