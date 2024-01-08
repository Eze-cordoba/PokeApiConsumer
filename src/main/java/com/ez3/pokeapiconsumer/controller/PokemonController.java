package com.ez3.pokeapiconsumer.controller;

import com.ez3.pokeapiconsumer.entidades.Pokemon;
import com.ez3.pokeapiconsumer.service.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private  PokeApiService pokeApiService;

    @GetMapping("/{pokemonName}")
    public ResponseEntity<?> getPokemonInfo(@PathVariable String pokemonName) {
        try {
          Pokemon pokemon= pokeApiService.getPokemonInfo(pokemonName);

            return ResponseEntity.ok(pokemon);



        } catch (HttpClientErrorException.NotFound notFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró información para el Pokémon: " + pokemonName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la solicitud.");
        }
    }




}
