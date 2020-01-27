package com.example.desafio7.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoCreateRequest {

    @NotEmpty( message = "Campo obrigatório")
    private String nome;

    @NotNull
    private Integer idcategoriaevento;

    @NotNull
    //@NotEmpty(message = "Data obrigatória")
    private Date datahorainicio;

    @NotNull
    //@NotEmpty(message = "Data obrigatória")
    private Date datahorafim;

    @NotEmpty(message = "Local obrigatório")
    @Size( max = 250)
    private String local;

    @NotEmpty(message = "Descrição obrigatória")
    @Size( max = 1000)
    private String descricao;

    @NotNull(message = "Campo obrigatório")
    private Integer limitevagas;
}