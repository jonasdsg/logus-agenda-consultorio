package br.com.logusretail.consultorio.utils.mapeadores;

import java.util.List;

public interface Mapeador<D, M> {
	public D toDTO(M model);

	public M toModel(D dto);

	public List<D> toListDTO(List<M> model);

	public List<M> toListModel(List<D> dto);
}
