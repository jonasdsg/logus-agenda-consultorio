package br.com.logusretail.consultorio.utils.parsers;

import static java.util.Objects.nonNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.logusretail.consultorio.entidades.consulta.ConsultaDTO;
import br.com.logusretail.consultorio.entidades.medico.Especialidade;

public class ValidaEspecialidade implements ConstraintValidator<ValidaMedicosPorEspecialidade, ConsultaDTO> {


	@Override
	public boolean isValid(ConsultaDTO consulta, ConstraintValidatorContext context) {
		Especialidade e = Especialidade.getInstance(consulta.especialidade);
		Integer m = consulta.medicos.size();
		if(nonNull(e) && nonNull(m)) {
			return (Especialidade.CIRURGIA == e && m<=2) ||(Especialidade.OUTRA == e && m==1);
		}
		
		return false;
	}

}
