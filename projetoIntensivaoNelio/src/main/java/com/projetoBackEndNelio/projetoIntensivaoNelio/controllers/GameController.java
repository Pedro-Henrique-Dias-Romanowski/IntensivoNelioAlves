package com.projetoBackEndNelio.projetoIntensivaoNelio.controllers;


import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameMinDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService service;


   @GetMapping("/findAll")
    public List<GameMinDTO> findAll(){
       return service.findAll();
   }

   @GetMapping("/{id}")
    public GameDTO findById(@PathVariable Long id){
       return service.findById(id);
    }

}
