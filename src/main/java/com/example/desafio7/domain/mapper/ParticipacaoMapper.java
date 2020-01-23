package com.example.desafio7.domain.mapper;

import com.example.desafio7.domain.dto.request.ParticipacaoCreateRequest;
import com.example.desafio7.domain.dto.response.ParticipacaoResponse;
import com.example.desafio7.domain.entities.Evento;
import com.example.desafio7.domain.entities.Participacao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParticipacaoMapper {

    private final ModelMapper mapper;

    @Autowired
    public ParticipacaoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ParticipacaoResponse toDto(Participacao input) {
        return mapper.map(input, ParticipacaoResponse.class);
    }

    public Participacao fromDto(ParticipacaoCreateRequest input) {
        
        Participacao participacao = mapper.map(input, Participacao.class);

        Evento evento = new Evento();
        evento.setIdEvento(input.getIdEvento());
         participacao.setEvento(evento);
 
        return participacao;
    }
}