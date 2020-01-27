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
    @Column (name = "idparticipacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idparticipacao;

    @JoinColumn (name = "IdEvento", nullable = false)
    @ManyToOne
    private Evento evento;

    @Column(name = "LoginParticipante", nullable = false, length = 250)
    private String loginparticipante;

    @Column(name = "FlagPresente", nullable = false, length = 250)
    private Boolean flagpresente;

    @Column(name = "Nota", nullable = true)
    private Integer nota;

    @Column(name = "Comentario", nullable = true, length = 1000)
    private String comentario;

} 