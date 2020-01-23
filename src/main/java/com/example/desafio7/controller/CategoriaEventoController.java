package com.example.desafio7.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.desafio7.domain.dto.response.CategoriaEventoResponse;
import com.example.desafio7.domain.mapper.CategoriaEventoMapper;
import com.example.desafio7.service.CategoriaEventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria evento")
public class CategoriaEventoController {

	private final CategoriaEventoService ctgeventoService;
	private final CategoriaEventoMapper mapper;

	@Autowired
	public CategoriaEventoController(CategoriaEventoService ctgeventoService, CategoriaEventoMapper ctgeventoMapper) {
		this.ctgeventoService = ctgeventoService;
		this.mapper = ctgeventoMapper;
	}
	@GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaEventoResponse> getById(@PathVariable Integer id) {
         return ResponseEntity.ok(mapper.toDto(ctgeventoService.findById(id))) ;
	}

	@GetMapping
	public ResponseEntity<List<CategoriaEventoResponse>> list() {
		return ResponseEntity.ok(ctgeventoService.listCategoriaEvento().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}	


}