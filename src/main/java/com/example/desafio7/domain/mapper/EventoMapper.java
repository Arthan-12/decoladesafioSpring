package com.example.desafio7.domain.mapper;

import com.example.desafio7.domain.dto.request.EventoCreateRequest;
import com.example.desafio7.domain.dto.response.EventoResponse;
import com.example.desafio7.domain.entities.CategoriaEvento;
import com.example.desafio7.domain.entities.Evento;
import com.example.desafio7.domain.entities.StatusEvento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    private final ModelMapper mapper;

    @Autowired
    public EventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public EventoResponse toDto(Evento input) {
        return mapper.map(input, EventoResponse.class);
    }

    public Evento fromDto(EventoCreateRequest input) {
        
        Evento evento = mapper.map(input, Evento.class);

        CategoriaEvento categoriaEvento = new CategoriaEvento();
        categoriaEvento.setIdCategoriaEvento(input.getIdCategoriaEvento());
         evento.setCategoriaevento(categoriaEvento);
        
 
        StatusEvento statusEvento = new StatusEvento();
        statusEvento.setIdEventoStatus(1);
        evento.setStatusevento(statusEvento);
 
 
        return evento;
    }
}