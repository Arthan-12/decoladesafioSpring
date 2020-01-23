package com.example.desafio7.service;

import java.util.List;
import java.util.Optional;

import com.example.desafio7.exception.DataNotFoundException;
import com.example.desafio7.domain.entities.CategoriaEvento;
import com.example.desafio7.repository.CategoriaEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaEventoService {

    private final CategoriaEventoRepository ctgeventoRepository;

    @Autowired
    public CategoriaEventoService(CategoriaEventoRepository ctgeventoRepository) {
        this.ctgeventoRepository = ctgeventoRepository;
    }

    public CategoriaEvento createCategoriaEvento(CategoriaEvento model) {
        return ctgeventoRepository.save(model);

    }
    
    public void delete(Integer id) {
        ctgeventoRepository.deleteById(id);
    }

    public CategoriaEvento updateUser(CategoriaEvento model){
        return ctgeventoRepository.save(model);
 
        }

        public List<CategoriaEvento> listCategoriaEvento() {
            return ctgeventoRepository.findAll();

    }
    public CategoriaEvento findById(Integer id) {
        Optional<CategoriaEvento> ctgevento = ctgeventoRepository.findById(id);
        return ctgevento.orElseThrow(() -> new DataNotFoundException("Categoria Evento Not found"));
	}

}


