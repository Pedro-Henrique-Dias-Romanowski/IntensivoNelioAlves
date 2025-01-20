package com.projetoBackEndNelio.projetoIntensivaoNelio.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_game")
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    @Column(name = "game_year")
    private Integer year;

    private String genre;

    private String plataform;

    private Double score;

    private String imgUrl;

    private String shortDescription;

    private String longDescription;

}
