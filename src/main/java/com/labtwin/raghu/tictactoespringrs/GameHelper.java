package com.labtwin.raghu.tictactoespringrs;

import com.labtwin.raghu.tictactoespringrs.vo.GameInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class GameHelper {

    private static final Logger logger = LogManager.getLogger(GameHelper.class);

    Map<Integer,String> userInfo;
    Map<Integer,GameInfo> gameInfo;

    private SecureRandom secureRandom;

    public GameHelper(){
        secureRandom= new SecureRandom();
        userInfo= new HashMap<>();
        gameInfo = new HashMap<>();
    }

    public int getRandomId(){
        return secureRandom.nextInt(10000);
    }

    // gameId-> currentgamestatus 123456789 000000000
    //123
    //456
    //789

    public void addGameInfo(GameInfo gameInfo){
        this.gameInfo.put(gameInfo.getGameId(), gameInfo);
    }
    public  GameInfo getGameInfo(Integer gameId){
        return this.gameInfo.get(gameId);
    }

    public  String getUserInfo(Integer userId) {
        return this.userInfo.get(userId);
    }

    public List<Integer> getGames(){
        logger.info("List of all games"+gameInfo.keySet());
            return new ArrayList<>(this.gameInfo.keySet());
    }


}
