package com.projetoBackEndNelio.projetoIntensivaoNelio.repositories;

import com.projetoBackEndNelio.projetoIntensivaoNelio.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
