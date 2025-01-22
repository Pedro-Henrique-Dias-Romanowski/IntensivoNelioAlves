package com.projetoBackEndNelio.projetoIntensivaoNelio.controllers;


import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameListDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameMinDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.services.GameListService;
import com.projetoBackEndNelio.projetoIntensivaoNelio.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
