package com.dani.meteo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dani.meteo.model.Citta;

public interface CittaRepo extends JpaRepository<Citta, Integer>{

    Optional<Citta> findByNome(String nome);
    

}
