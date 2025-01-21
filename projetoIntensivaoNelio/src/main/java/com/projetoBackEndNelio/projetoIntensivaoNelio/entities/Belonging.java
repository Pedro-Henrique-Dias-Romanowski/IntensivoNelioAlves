package com.projetoBackEndNelio.projetoIntensivaoNelio.entities;

import com.projetoBackEndNelio.projetoIntensivaoNelio.entities.pk.BelongingPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "tb_belonging")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Belonging {

    @EmbeddedId
    private BelongingPK id  = new BelongingPK();

    private Integer position;

    public Belonging(Game game, GameList list, Integer position){
        this.id.setGame(game);
        this.id.setList(list);
        this.position = position;
    }
}
