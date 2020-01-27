package com.example.desafio7.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.desafio7.domain.dto.request.ParticipacaoCreateRequest;
import com.example.desafio7.domain.dto.response.ParticipacaoResponse;
import com.example.desafio7.domain.entities.Participacao;
import com.example.desafio7.domain.mapper.ParticipacaoMapper;
import com.example.desafio7.service.ParticipacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/participacao")
public class ParticipacaoController {

	private final ParticipacaoService participacaoService;
	private final ParticipacaoMapper mapper;

	@Autowired
	public ParticipacaoController(ParticipacaoService participacaoService, ParticipacaoMapper participacaoMapper) {
		this.participacaoService = participacaoService;
		this.mapper = participacaoMapper;
	}
	@GetMapping(value = "/{id}")
    public ResponseEntity<ParticipacaoResponse> getById(@PathVariable Integer id) {
         return ResponseEntity.ok(mapper.toDto(participacaoService.findById(id))) ;
	}

	@GetMapping
	public ResponseEntity<List<ParticipacaoResponse>> list() {
		return ResponseEntity.ok(participacaoService.listParticipacao().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}	

    
    @PostMapping
	public ResponseEntity<ParticipacaoResponse> post(@Valid @RequestBody ParticipacaoCreateRequest model) {

		Participacao participacao = participacaoService.createParticipacao(mapper.fromDto(model));

		return ResponseEntity.ok(mapper.toDto(participacao));
	}

	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
	    participacaoService.delete(id);
		return ResponseEntity.ok(true);
    }
    
    @PutMapping
	public ResponseEntity<ParticipacaoResponse> put(@Valid @RequestBody Participacao participacao) {
		if(participacaoService.findById(participacao.getIdparticipacao())!= null){
            participacao = participacaoService.updateUser(participacao);
        }
    return ResponseEntity.ok(mapper.toDto(participacao));
    }  
}