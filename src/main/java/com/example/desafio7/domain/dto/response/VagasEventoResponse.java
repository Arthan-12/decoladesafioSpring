package com.example.desafio7.domain.dto.response;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VagasEventoResponse {
 
    private String nomeevento;
 
    private Integer limitevagas;
 
    private Integer vagasdisponiveis;

}