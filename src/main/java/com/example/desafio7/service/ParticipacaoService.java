package com.example.desafio7.service;

import java.util.List;
import java.util.Optional;

import com.example.desafio7.exception.DataNotFoundException;
import com.example.desafio7.domain.entities.Participacao;
import com.example.desafio7.repository.ParticipacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipacaoService {

    private final ParticipacaoRepository participacaoRepository;

    @Autowired
    public ParticipacaoService(ParticipacaoRepository participacaoRepository) {
        this.participacaoRepository = participacaoRepository;
    }

    public Participacao createParticipacao(Participacao model) {
        return participacaoRepository.save(model);

    }
    
    public void delete(Integer id) {
        participacaoRepository.deleteById(id);
    }

    public Participacao updateUser(Participacao model){
        return participacaoRepository.save(model);
 
        }

    public List<Participacao> listParticipacao() {
        return participacaoRepository.findAll();

    }
    public Participacao findById(Integer id) {
        Optional<Participacao> participacao = participacaoRepository.findById(id);
        return participacao.orElseThrow(() -> new DataNotFoundException("Participacao Not found"));
	}



    public  List<String> listDistinct() {
        return participacaoRepository.listDistinct();
    }
}


