package br.com.logusretail.consultorio.entidades.medico;

public enum Especialidade {
	CIRURGIA("Cirurgia"), OUTRA("Outras Categorias");

	private String descricao;

	Especialidade(String desc) {
		this.descricao = desc;
	}

	public static Especialidade getInstance(String desc) {
		if (desc != null) {
			return (CIRURGIA.getDescricao().toLowerCase().equals(desc.toLowerCase())) ? CIRURGIA : OUTRA;
		}
		return null;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
