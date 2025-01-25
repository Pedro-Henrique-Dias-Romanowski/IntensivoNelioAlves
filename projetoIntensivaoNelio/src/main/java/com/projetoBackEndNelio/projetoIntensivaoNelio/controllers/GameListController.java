package com.projetoBackEndNelio.projetoIntensivaoNelio.controllers;


import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameListDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameMinDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.ReplacementDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.services.GameListService;
import com.projetoBackEndNelio.projetoIntensivaoNelio.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;


    @GetMapping("/findAll")
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.sourceIndex(), body.destinationIndex());
    }
}
