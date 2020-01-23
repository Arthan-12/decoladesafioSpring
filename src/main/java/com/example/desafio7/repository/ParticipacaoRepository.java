package com.example.desafio7.repository;

import java.util.List;

import com.example.desafio7.domain.entities.Participacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Integer> {

    @Query(nativeQuery = true, value = "select distinct name from Participacao")
    List<String> listDistinct();

} 
