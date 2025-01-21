package com.projetoBackEndNelio.projetoIntensivaoNelio.services;


import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameMinDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.entities.Game;
import com.projetoBackEndNelio.projetoIntensivaoNelio.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    public List<GameMinDTO> findAll(){
        List<Game> listGames = gameRepository.findAll();
        return listGames.stream().map(x -> new GameMinDTO(x.getId(), x.getTitle(), x.getYear(), x.getImgUrl(), x.getShortDescription())).toList();
    }


}
