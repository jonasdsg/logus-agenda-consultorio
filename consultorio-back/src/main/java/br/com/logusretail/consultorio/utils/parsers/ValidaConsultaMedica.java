package br.com.logusretail.consultorio.utils.parsers;

import static java.util.Objects.nonNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.logusretail.consultorio.entidades.consulta.ConsultaDTO;
import br.com.logusretail.consultorio.entidades.medico.Especialidade;
import br.com.logusretail.consultorio.servicos.ValidacaoService;

public class ValidaConsultaMedica implements ConstraintValidator<ValidaConsulta, ConsultaDTO> {

	@Autowired
	private ValidacaoService validacaoService;
	
	@Override
	public boolean isValid(ConsultaDTO consulta, ConstraintValidatorContext context) {
		if(nonNull(consulta)) {
			Especialidade e = Especialidade.getInstance(consulta.especialidade);
			Integer m = consulta.medicos.size();
			if(nonNull(e) && nonNull(m)) {
				return (Especialidade.CIRURGIA == e && m<=2) ||(Especialidade.OUTRA == e && m==1) 
						&& validacaoService.validarConsulta(consulta);
			} else return false;
			
		}
		
		return false;
	}

}
