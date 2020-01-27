package com.example.desafio7.domain.mapper;

import static org.junit.Assert.assertEquals;

import com.example.desafio7.configuration.MapperConfig;
import com.example.desafio7.domain.dto.request.CategoriaEventoCreateRequest;
import com.example.desafio7.domain.dto.response.CategoriaEventoResponse;
import com.example.desafio7.domain.entities.CategoriaEvento;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

/**
 * ClientMapperTest
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriaEventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private CategoriaEventoMapper mapper;

    @Test
    public void shouldConvertCategoriaEventoToCategoriaEventoResponse() {
        CategoriaEvento entity = CategoriaEvento.builder().idcategoriaevento(1).nomecategoria("name").build();
        CategoriaEventoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdcategoriaevento(), entity.getIdcategoriaevento());
        assertEquals("Unexpected value found!", dto.getNomecategoria(), entity.getNomecategoria());
    }

    @Test
    public void shouldConvertCategoriaEventoCreateRequestToCategoriaEvento() {
        CategoriaEventoCreateRequest dto = CategoriaEventoCreateRequest.builder().nomecategoria("name").build();

        CategoriaEvento entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getNomecategoria(), entity.getNomecategoria());
    }

} 