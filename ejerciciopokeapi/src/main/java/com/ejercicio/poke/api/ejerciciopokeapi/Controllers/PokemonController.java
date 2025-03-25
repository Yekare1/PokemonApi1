package com.ejercicio.poke.api.ejerciciopokeapi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.poke.api.ejerciciopokeapi.entities.Pokemon;
import com.ejercicio.poke.api.ejerciciopokeapi.entities.PokemonEntity;
import com.ejercicio.poke.api.ejerciciopokeapi.services.PokemonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping({ "/name/{name}" })
    public Pokemon getPokemonByName(@PathVariable String name) {
        return pokemonService.getPokemonByName(name);
    }

    @GetMapping("/test")
public String test() {
    return "Funciona!";
}

    @GetMapping({ "/id/{id}" })
    public Pokemon getPokemonById(@PathVariable Integer id) {
        return pokemonService.getPokemonById(id);
    }
    
    @GetMapping("/type/{type}")
    public List<Pokemon> getPokemonByTypes(@PathVariable String type) {
        return pokemonService.getPokemonByTypes(type);
    }

    @PostMapping("/save")
    public PokemonEntity savePokemon(@RequestBody PokemonEntity pokemon) {
        return pokemonService.savePokemon(pokemon);
    }
    
    @GetMapping("/all")
    public List<PokemonEntity> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

}
