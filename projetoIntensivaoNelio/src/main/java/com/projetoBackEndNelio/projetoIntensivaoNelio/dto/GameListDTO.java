package com.projetoBackEndNelio.projetoIntensivaoNelio.dto;

import com.projetoBackEndNelio.projetoIntensivaoNelio.entities.GameList;

public record GameListDTO(Long id, String name) {

    public GameListDTO(GameList gameList){
        this(gameList.getId(),gameList.getName());
    }

}
