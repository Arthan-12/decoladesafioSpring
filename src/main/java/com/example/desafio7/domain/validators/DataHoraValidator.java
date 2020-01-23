package com.example.desafio7.domain.validators;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafio7.domain.dto.request.EventoCreateRequest;

public class DataHoraValidator implements ConstraintValidator<DataHora, EventoCreateRequest> {

    @Override
    public boolean isValid(EventoCreateRequest value, ConstraintValidatorContext context) {
        Long timeInicio = value.getDataHoraInicio().getTime();
        Long timeFim = value.getDataHoraFim().getTime();
        Long dataevento = timeFim - timeInicio;
 
        if(dataevento <= 0) return false;
        if(timeInicio < new Date().getTime() + 86400000) return false;
 
        Calendar inicio = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();
 
        inicio.setTime(value.getDataHoraInicio());
        fim.setTime(value.getDataHoraFim());
 
        if(inicio.get(Calendar.DAY_OF_MONTH) != fim.get(Calendar.DAY_OF_MONTH)) return false;
        if(inicio.get(Calendar.MONTH) != fim.get(Calendar.MONTH)) return false;
        if(inicio.get(Calendar.YEAR) != fim.get(Calendar.YEAR)) return false;
        return true;
    }


} 