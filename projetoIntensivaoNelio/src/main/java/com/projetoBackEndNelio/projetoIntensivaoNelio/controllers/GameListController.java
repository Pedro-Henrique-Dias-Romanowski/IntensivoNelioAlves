package com.projetoBackEndNelio.projetoIntensivaoNelio.controllers;


import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameListDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    GameListService gameListService;


    @GetMapping("/findAll")
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }
}
