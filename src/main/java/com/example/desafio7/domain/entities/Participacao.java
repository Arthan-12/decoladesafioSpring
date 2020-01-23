package com.example.desafio7.domain.entities;

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
public class Participacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdParticipacao;

    @JoinColumn (name = "IdEvento", nullable = false)
    @ManyToOne
    private Evento evento;

    @Column(nullable = false, length = 250)
    private String LoginParticipante;

    @Column(nullable = false, length = 250)
    private Boolean FlagPresente;

    @Column(nullable = true)
    private Integer Nota;

    @Column(nullable = true, length = 1000)
    private String Comentario;

} 