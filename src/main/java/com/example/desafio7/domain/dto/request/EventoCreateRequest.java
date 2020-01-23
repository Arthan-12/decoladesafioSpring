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

    @NotEmpty(message = "Campo obrigatório")
    private String Nome;

    @NotNull
    private Integer IdCategoriaEvento;

    @NotNull
    //@NotEmpty(message = "Data obrigatória")
    private Date DataHoraInicio;

    @NotNull
    //@NotEmpty(message = "Data obrigatória")
    private Date DataHoraFim;

    @NotEmpty(message = "Local obrigatório")
    @Size( max = 250)
    private String Local;

    @NotEmpty(message = "Descrição obrigatória")
    @Size( max = 1000)
    private String Descricao;

    @NotNull(message = "Campo obrigatório")
    private Integer LimiteVagas;
}