package com.example.desafio7.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.desafio7.domain.dto.request.EventoCreateRequest;
import com.example.desafio7.domain.dto.response.EventoResponse;
import com.example.desafio7.domain.entities.Evento;
import com.example.desafio7.domain.mapper.EventoMapper;
import com.example.desafio7.service.EventoService;

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
@RequestMapping("/ evento")
public class EventoController {

	private final EventoService eventoService;
	private final EventoMapper mapper;

	@Autowired
	public EventoController(EventoService eventoService, EventoMapper eventoMapper) {
		this.eventoService = eventoService;
		this.mapper = eventoMapper;
	}
	@GetMapping(value = "/{id}")
    public ResponseEntity<EventoResponse> getById(@PathVariable Integer id) {
         return ResponseEntity.ok(mapper.toDto(eventoService.findById(id))) ;
	}

	@GetMapping
	public ResponseEntity<List<EventoResponse>> list() {
		return ResponseEntity.ok(eventoService.listEvento().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}	

    
    @PostMapping
	public ResponseEntity<EventoResponse> post(@Valid @RequestBody EventoCreateRequest model) {

		Evento evento = eventoService.createEvento(mapper.fromDto(model));

		return ResponseEntity.ok(mapper.toDto(evento));
	}

	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
	    eventoService.delete(id);
		return ResponseEntity.ok(true);
    }
    
    @PutMapping
	public ResponseEntity<EventoResponse> put(@Valid @RequestBody Evento evento) {
		if(eventoService.findById(evento.getIdEvento())!= null){
            evento = eventoService.updateUser(evento);
        }
    return ResponseEntity.ok(mapper.toDto(evento));
	}  
	
	@PutMapping (value = "/{id}/ alterar evento")
	public ResponseEntity<EventoResponse> eventoAndamento(@Valid @RequestBody Integer id) {
		Evento mudaevento = new Evento();
		mudaevento = eventoService.findById(id);
		if(eventoService.findById(mudaevento.getIdEvento())!= null){
            mudaevento = eventoService.eventoAndamento(id);
        }
    return ResponseEntity.ok(mapper.toDto(mudaevento));
	}  
	
	@PutMapping (value = "/{id}/ concluir evento")
	public ResponseEntity<EventoResponse> eventoConcluido(@Valid @RequestBody Integer id) {
		Evento mudaevento = new Evento();
		mudaevento = eventoService.findById(id);
		if(eventoService.findById(mudaevento.getIdEvento())!= null){
            mudaevento = eventoService.eventoConcluido(id);
        }
    return ResponseEntity.ok(mapper.toDto(mudaevento));
	}  

	@PutMapping (value = "/{id}/ cancelar evento")
	public ResponseEntity<EventoResponse> eventoCancelado(@Valid @RequestBody Integer id) {
		Evento mudaevento = new Evento();
		mudaevento = eventoService.findById(id);
		if(eventoService.findById(mudaevento.getIdEvento())!= null){
            mudaevento = eventoService.eventoCancelado(id);
        }
    return ResponseEntity.ok(mapper.toDto(mudaevento));
	}  

}