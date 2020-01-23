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

    private int IdEvento;

    private StatusEvento statusevento;

    private CategoriaEvento categoriaevento;

    private String Nome;

    private Date DataHoraInicio;

    private Date DataHoraFim;

    private String Local;

    private String Descricao;

    private int LimiteVagas;

}