package com.projetoBackEndNelio.projetoIntensivaoNelio.entities.pk;

import com.projetoBackEndNelio.projetoIntensivaoNelio.entities.Game;
import com.projetoBackEndNelio.projetoIntensivaoNelio.entities.GameList;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class BelongingPK {

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

}
