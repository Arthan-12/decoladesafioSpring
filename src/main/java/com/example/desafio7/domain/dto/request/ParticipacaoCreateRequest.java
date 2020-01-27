package com.example.desafio7.domain.dto.request;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoCreateRequest {

    @NotNull
    private Integer idevento;

    @NotEmpty(message = "Campo obrigatório")
    private String loginparticipante;

    @NotNull
    private Boolean flagpresente;

    private Integer nota;

    private String comentário;
}