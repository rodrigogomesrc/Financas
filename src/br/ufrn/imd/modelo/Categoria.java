package br.ufrn.imd.modelo;

public class Categoria {
	
	private String id;
	private String nomeCategoria;
	private String descricaoCategoria;
	private TipoMovimentacao tipoCategoria;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}
	
	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public TipoMovimentacao getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(TipoMovimentacao tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}
	
}
