package com.example.desafio7.service;

import java.util.List;
import java.util.Optional;

import com.example.desafio7.exception.DataNotFoundException;
import com.example.desafio7.domain.entities.Evento;
import com.example.desafio7.domain.entities.StatusEvento;
import com.example.desafio7.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento createEvento(Evento model) {
        return eventoRepository.save(model);

    }
    
    public void delete(Integer id) {
        eventoRepository.deleteById(id);
    }

    public Evento updateUser(Evento model){
        return eventoRepository.save(model);
 
        }

    public List<Evento> listEvento() {
        return eventoRepository.findAll();

    }

    public Evento eventoAndamento(Integer id) {
        return mudarEvento(id, 2);
    }

    public Evento eventoConcluido(Integer id) {
        return mudarEvento(id, 3);
    }

    public Evento eventoCancelado(Integer id) {
        return mudarEvento(id, 4);
    }

    public Evento findById(Integer id) {
        Optional<Evento> ctgevento = eventoRepository.findById(id);
        return ctgevento.orElseThrow(() -> new DataNotFoundException("Evento Not found"));
    }
    
    public Evento mudarEvento(Integer id, int status) {
        StatusEvento mudaStatus = new StatusEvento();
        Evento mudaEvento = new Evento();
        mudaEvento = findById(id);
        mudaStatus.setIdEventoStatus(status);
        mudaEvento.setStatusevento(mudaStatus);
        return eventoRepository.save(mudaEvento);
    }

}


