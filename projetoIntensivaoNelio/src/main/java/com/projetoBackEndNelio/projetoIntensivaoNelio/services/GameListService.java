package com.projetoBackEndNelio.projetoIntensivaoNelio.services;


import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameListDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.entities.GameList;
import com.projetoBackEndNelio.projetoIntensivaoNelio.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;



    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> gameLists = gameListRepository.findAll();
        return gameLists.stream().map(gameList -> new GameListDTO(gameList)).toList();
    }
}
