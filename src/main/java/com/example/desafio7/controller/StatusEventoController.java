package com.example.desafio7.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.desafio7.domain.dto.response.StatusEventoResponse;
import com.example.desafio7.domain.mapper.StatusEventoMapper;
import com.example.desafio7.service.StatusEventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status evento")
public class StatusEventoController {

	private final StatusEventoService steventoService;
	private final StatusEventoMapper mapper;

	@Autowired
	public StatusEventoController(StatusEventoService steventoService, StatusEventoMapper steventoMapper) {
		this.steventoService = steventoService;
		this.mapper = steventoMapper;
	}
	@GetMapping(value = "/{id}")
    public ResponseEntity<StatusEventoResponse> getById(@PathVariable Integer id) {
         return ResponseEntity.ok(mapper.toDto(steventoService.findById(id))) ;
	}

	@GetMapping
	public ResponseEntity<List<StatusEventoResponse>> list() {
		return ResponseEntity.ok(steventoService.listStatusEvento().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}	


}