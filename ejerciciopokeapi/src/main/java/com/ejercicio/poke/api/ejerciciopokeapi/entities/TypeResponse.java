package com.ejercicio.poke.api.ejerciciopokeapi.entities;

import java.util.List;

public class TypeResponse {
    private List<PokemonEntry> pokemon;

    public List<PokemonEntry> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<PokemonEntry> pokemon) {
        this.pokemon = pokemon;
    }

    public static class PokemonEntry{

        private PokemonInfo pokemon;

        public PokemonInfo getPokemon() {
            return pokemon;
        }

        public void setPokemon(PokemonInfo pokemon) {
            this.pokemon = pokemon;
        }


    }
public static class PokemonInfo{
    private String name;
    private String url;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}

}
