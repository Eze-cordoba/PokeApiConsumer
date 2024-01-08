package com.ez3.pokeapiconsumer.entidades;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ability {
    private AbilityInfo ability;
    private boolean is_hidden;
    private int slot;
}
