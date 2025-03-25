package com.ejercicio.poke.api.ejerciciopokeapi.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejercicio.poke.api.ejerciciopokeapi.entities.Pokemon;
import com.ejercicio.poke.api.ejerciciopokeapi.entities.PokemonEntity;
import com.ejercicio.poke.api.ejerciciopokeapi.entities.TypeResponse;
import com.ejercicio.poke.api.ejerciciopokeapi.entities.TypeResponse.PokemonEntry;
import com.ejercicio.poke.api.ejerciciopokeapi.repositories.PokemonRepository;

@Service
public class PokemonService {

    // Inyección de las dependencias
    private final PokemonRepository pokemonRepository;
    private final RestTemplate restTemplate;

    // Consumo de la API
    private static final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon/";

    @Autowired
    public PokemonService(RestTemplate restTemplate, PokemonRepository pokemonRepository) {
        this.restTemplate = restTemplate;
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon getPokemonByName(String name) {
        String url = POKEAPI_URL + name;
        return restTemplate.getForObject(url, Pokemon.class);
    }

    public Pokemon getPokemonById(int id) {
        String url = POKEAPI_URL + id;
        return restTemplate.getForObject(url, Pokemon.class);
    }

    public List<Pokemon> getPokemonByTypes(String type) {

        String url = "https://pokeapi.co/api/v2/type/" + type;

        TypeResponse typeResponse = restTemplate.getForObject(url, TypeResponse.class);

        if (typeResponse != null && typeResponse.getPokemon() != null) {

            List<PokemonEntry> allpokemon = typeResponse.getPokemon();

            // Mezcla la lista para obtener pokemon al azar
            Collections.shuffle(allpokemon);

            return allpokemon.stream().limit(10)
                    .map(pokemonEntry -> {
                        String pokemonUrl = pokemonEntry.getPokemon().getUrl();
                        return restTemplate.getForObject(pokemonUrl, Pokemon.class);
                    })
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    // Guarda un Pokemon en la base de datos
    public PokemonEntity savePokemon(PokemonEntity pokemon) {
        return pokemonRepository.save(pokemon);
    }

    // Obtener todos los Pokémon de la base de datos
    public List<PokemonEntity> getAllPokemon() {
        return pokemonRepository.findAll();
    }

}
