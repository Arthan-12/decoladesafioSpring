package com.example.desafio7.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Evento {

    @Id 
    @Column (name = "IdEvento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idevento;

    @JoinColumn (name = "IdEventoStatus", nullable = false)
    @ManyToOne
    private StatusEvento statusevento;

    @JoinColumn (name = "IdCategoriaEvento", nullable = false)
    @ManyToOne
    private CategoriaEvento categoriaevento;

    @Column(name = "Nome", nullable = false, length = 250)
    private String nome;

    @Column(name = "DataHoraInicio", nullable = false, length = 250)
    private Date datahorainicio;

    @Column(name = "DataHoraFim", nullable = false, length = 250)
    private Date datahorafim;

    @Column(name = "Local", nullable = false, length = 250)
    private String local;

    @Column(name = "Descricao", nullable = false, length = 1000)
    private String descricao;

    @Column(name = "LimiteVagas", nullable = false)
    private Integer limitevagas;


} 