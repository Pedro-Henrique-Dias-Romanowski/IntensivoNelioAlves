package com.projetoBackEndNelio.projetoIntensivaoNelio.repositories;

import com.projetoBackEndNelio.projetoIntensivaoNelio.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
