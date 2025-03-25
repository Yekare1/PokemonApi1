package com.ejercicio.poke.api.ejerciciopokeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.poke.api.ejerciciopokeapi.entities.PokemonEntity;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {


}
