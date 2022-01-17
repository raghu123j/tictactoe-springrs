package com.labtwin.raghu.tictactoespringrs;

import com.labtwin.raghu.tictactoespringrs.vo.GameMove;
import com.labtwin.raghu.tictactoespringrs.vo.GameInfo;
import com.labtwin.raghu.tictactoespringrs.vo.GameVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class HomeController {

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @Autowired
    private GamePlayService gamePlayService;

    @Autowired
    private GameHelper gameHelper;

    @GetMapping("/home")
    public String home(){
        return "Welcome to Home!";
    }

    @GetMapping(value = "/user")
    public String getUser(@RequestParam String name) {
        return "Hello "+name;
    }

    @GetMapping(value = "/winner/{gameId}")
    public  String getWinner(@PathVariable Integer gameId) {
        logger.info("Winner/Status of gameId:"+gameId);
        return gamePlayService.checkWinner(gameHelper.getGameInfo(gameId).getBoard());
    }

    @GetMapping(value ="/games")
    @ResponseBody
    public List<Integer> getAllGames() {
        return (List<Integer>) gameHelper.getGames();
    }

    @GetMapping("/games/new")
    @ResponseBody
    public ResponseEntity<GameVO> createNewGame() {
        GameInfo gameInfo= new GameInfo(gameHelper.getRandomId());
        gameHelper.addGameInfo(gameInfo);
        return new ResponseEntity<>(new GameVO(gameInfo.getGameId()), HttpStatus.CREATED);
    }


    @PostMapping("/move")
    public Map<String,String> turn(@RequestBody GameMove gameMove) {
          GameInfo gameInfo= gameHelper.getGameInfo(gameMove.getGameId());
          gamePlayService.updateState(String.valueOf(gameMove.getPostion()), String.valueOf(gameMove.getPlayerId()), (HashMap) gameInfo.getBoard());
          return gameInfo.getBoard();
    }

   @GetMapping("/status/{gameId}")
   public  String getStatus(@PathVariable Integer gameId) {
       logger.info("Status of gameId:"+gameId);
       return gameHelper.getGameInfo(gameId).getBoard().toString();
   }


}
