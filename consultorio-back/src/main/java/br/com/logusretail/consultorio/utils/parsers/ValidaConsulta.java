package br.com.logusretail.consultorio.utils.parsers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidaConsultaMedica.class })
public @interface ValidaConsulta {
	String message() default "Valor inválido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String value() default "";
}
