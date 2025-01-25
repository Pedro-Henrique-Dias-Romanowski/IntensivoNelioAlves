package com.projetoBackEndNelio.projetoIntensivaoNelio.services;


import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameMinDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.entities.Game;
import com.projetoBackEndNelio.projetoIntensivaoNelio.projections.GameMinProjection;
import com.projetoBackEndNelio.projetoIntensivaoNelio.repositories.GameRepository;
import com.projetoBackEndNelio.projetoIntensivaoNelio.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> listGames = gameRepository.findAll();
        return listGames.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
   public GameDTO findById(Long id){
        Game game = gameRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Game not found"));

       return new GameDTO(game);
   }

   @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
   }
}
