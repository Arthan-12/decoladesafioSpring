package com.example.desafio7.service;

import java.util.List;
import java.util.Optional;

import com.example.desafio7.exception.DataNotFoundException;
import com.example.desafio7.domain.entities.StatusEvento;
import com.example.desafio7.repository.StatusEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusEventoService {

    private final StatusEventoRepository steventoRepository;

    @Autowired
    public StatusEventoService(StatusEventoRepository steventoRepository) {
        this.steventoRepository = steventoRepository;
    }

    public StatusEvento createCategoriaEvento(StatusEvento model) {
        return steventoRepository.save(model);

    }
    
    public void delete(Integer id) {
        steventoRepository.deleteById(id);
    }

    public StatusEvento updateUser(StatusEvento model){
        return steventoRepository.save(model);
 
        }

        public List<StatusEvento> listStatusEvento() {
            return steventoRepository.findAll();

    }
    public StatusEvento findById(Integer id) {
        Optional<StatusEvento> statusevento = steventoRepository.findById(id);
        return statusevento.orElseThrow(() -> new DataNotFoundException("Categoria Evento Not found"));
	}


}


