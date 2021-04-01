package br.ufrn.imd.modelo;

import java.util.Date;

public class Movimentacao {

	private String id;
	private Date data;
	private String categoriaId;
	private double valorMovimentacao;
	private TipoMovimentacao tipoMovimentacao;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
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
	
	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	
	public void setTipoMovimentacao(TipoMovimentacao tipo) {
		this.tipoMovimentacao = tipo;
	}
	
}
