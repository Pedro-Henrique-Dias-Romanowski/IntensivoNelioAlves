package com.projetoBackEndNelio.projetoIntensivaoNelio.services;


import com.projetoBackEndNelio.projetoIntensivaoNelio.dto.GameListDTO;
import com.projetoBackEndNelio.projetoIntensivaoNelio.entities.GameList;
import com.projetoBackEndNelio.projetoIntensivaoNelio.projections.GameMinProjection;
import com.projetoBackEndNelio.projetoIntensivaoNelio.repositories.GameListRepository;
import com.projetoBackEndNelio.projetoIntensivaoNelio.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> gameLists = gameListRepository.findAll();
        return gameLists.stream().map(gameList -> new GameListDTO(gameList)).toList();
    }


    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection object = list.remove(sourceIndex);
        list.add(destinationIndex, object);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex: sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
