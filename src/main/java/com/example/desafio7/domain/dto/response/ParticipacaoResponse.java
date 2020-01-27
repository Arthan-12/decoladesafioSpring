package com.example.desafio7.domain.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoResponse {

    private int idparticipacao;

    private int idevento;

    private String loginparticipante;

    private Boolean flagpresente;

    private int nota;

    private String comentario;

}