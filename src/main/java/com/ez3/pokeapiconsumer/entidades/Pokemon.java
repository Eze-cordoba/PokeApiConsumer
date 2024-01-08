package com.ez3.pokeapiconsumer.entidades;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

    private int id;
    private String name;
    private int height;
    private int weight;
    private int base_experience;
    private List<Ability> abilities;
}
