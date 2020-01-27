/*

package com.example.desafio7.domain.validators;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafio7.domain.entities.Evento;

public class DataEventoValidator implements ConstraintValidator<DataEvento, Evento> {

    @Override
    public boolean isValid(Evento value, ConstraintValidatorContext context) {
        Calendar hoje = Calendar.getInstance();
        Calendar diaevento = Calendar.getInstance();

        diaevento.setTime(value.getDataHoraInicio());

        if (hoje == diaevento) { return true;
        } else {
        return false;
        }
    }


} 
*/