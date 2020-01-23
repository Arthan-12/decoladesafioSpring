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
    private Integer IdEvento;

    @NotEmpty(message = "Campo obrigatório")
    private String LoginParticipante;

    @NotNull
    private Boolean FlagPresente;

    private Integer Nota;

    private String Comentário;
}