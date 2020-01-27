
package com.example.desafio7.domain.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = DataHoraValidator.class)
@Documented
public @interface DataEvento {

    String message() default "Data Inválida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

} 
