package br.imd.ufrn.financas.modelo;

public class Movimentacao {

	private String id;
	private Data data;
	private String categoriaId;
	private double valorMovimentacao;
	private short tipoMovimentacao;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Data getData() {
		return data;
	}
	
	public void setData(Data data) {
		this.data = data;
	}
	
	public String getCategoriaId() {
		return categoriaId;
	}
	
	public void setCategoriaId(String categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	public double getValorMovimentacao() {
		return valorMovimentacao;
	}
	
	public void setValorMovimentacao(double valorMovimentacao) {
		this.valorMovimentacao = valorMovimentacao;
	}
	
	public short getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	
	public void setTipoMovimentacao(short tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
}
