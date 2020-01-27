package com.example.desafio7.domain.dto.response;

import java.util.Date;

import com.example.desafio7.domain.entities.CategoriaEvento;
import com.example.desafio7.domain.entities.StatusEvento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoResponse {

    private int idevento;

    private StatusEvento statusevento;

    private CategoriaEvento categoriaevento;

    private String nome;

    private Date datahorainicio;

    private Date datahorafim;

    private String local;

    private String descricao;

    private int limitevagas;

}