package com.example.desafio7.repository;


import com.example.desafio7.domain.entities.Participacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Integer> {

    @Query(nativeQuery = true, value =  "SELECT COUNT(*) FROM Participacao WHERE IdEvento = :idEvento")
    int qtdInscritosEvento(Integer idEvento);

} 
