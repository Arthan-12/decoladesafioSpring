
package com.example.desafio7.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.desafio7.domain.dto.request.CategoriaEventoCreateRequest;
import com.example.desafio7.domain.dto.response.CategoriaEventoResponse;
import com.example.desafio7.domain.entities.CategoriaEvento;
import com.example.desafio7.domain.mapper.CategoriaEventoMapper;
import com.example.desafio7.service.CategoriaEventoService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * CategoriaEventoControllerTest
 */

 
@RunWith(MockitoJUnitRunner.class)
public class CategoriaEventoControllerTest {

    @Mock
    private CategoriaEventoMapper mapper;

    @Mock
    private CategoriaEventoService service;

    @InjectMocks
    private CategoriaEventoController controller;

    private final Integer id = 1;
    private final String nomecategoria = "Some string";


    CategoriaEvento entity = CategoriaEvento.builder().idcategoriaevento(id).nomecategoria(nomecategoria).build();

    CategoriaEventoCreateRequest createDto = CategoriaEventoCreateRequest.builder().nomecategoria(nomecategoria).build();

    CategoriaEventoResponse responseDto = CategoriaEventoResponse.builder().idcategoriaevento(id).nomecategoria(nomecategoria).build();


    @Test
    public void should_GetById() {
        //given
        when(service.findById(any())).thenReturn(entity);
        when(mapper.toDto(any())).thenReturn(responseDto);


        // when
        ResponseEntity<CategoriaEventoResponse> response = controller.getById(1);

        //then
        assertEquals("Deve ser 0k /200", response.getStatusCode(), HttpStatus.OK);
    }

   
} 