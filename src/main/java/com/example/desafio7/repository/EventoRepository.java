package com.example.desafio7.repository;

import java.util.List;

import com.example.desafio7.domain.entities.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM [dbo].[Evento]")
    List<String> listDistinct();

} 
