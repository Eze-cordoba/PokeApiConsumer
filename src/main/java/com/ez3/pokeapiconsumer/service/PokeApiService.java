package com.ez3.pokeapiconsumer.service;

import com.ez3.pokeapiconsumer.entidades.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiService {

    private final  String apiUrl = "https://pokeapi.co/api/v2/";

    private final RestTemplate restTemplate;

    public PokeApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


/**
 * @param pokemonName El nombre del Pokémon del cual se desea obtener la información.
 * @return Un objeto Pokemon que contiene detalles sobre el Pokémon especificado.
 **/
    public Pokemon getPokemonInfo(String pokemonName) {
        String url = apiUrl + "pokemon/" + pokemonName;
        return restTemplate.getForObject(url, Pokemon.class);
    }


}
