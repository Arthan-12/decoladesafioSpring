package com.example.desafio7.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class StatusEvento {

    @Id
    @Column (name = "IdEventoStatus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ideventostatus;

    @Column(name = "NomeStatus", nullable = false, length = 250)
    private String nomestatus;

} 