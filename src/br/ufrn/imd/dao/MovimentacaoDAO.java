package br.ufrn.imd.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.DadosCSV;
import br.ufrn.imd.modelo.Movimentacao;
import br.ufrn.imd.modelo.TipoMovimentacao;


public class MovimentacaoDAO implements DadosCSV{
	
	private static MovimentacaoDAO instancia;
	private ArrayList<Movimentacao> movimentacoes;
	
	public MovimentacaoDAO() {
		this.movimentacoes = new ArrayList<Movimentacao>();
		this.lerDados();
	}

	public static synchronized MovimentacaoDAO getInstancia() {
		if (instancia == null)
			instancia = new MovimentacaoDAO();

		return instancia;
	}
	
	public void salvarMovimentacao(Movimentacao movimentacao) {
		this.movimentacoes.add(movimentacao);
		this.salvarDados();
	}
	
	public ArrayList<Movimentacao> getMovimentacoes(){
		return this.movimentacoes;
	}
	
	public Movimentacao getMovimentacao(String idMovimentacao) {
		for(Movimentacao m: this.movimentacoes) {
			if(m.getId().equals(idMovimentacao)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Movimentacao> getMovimentacoesAno(int ano) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> movimentacoesAno = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
	
			cal.setTime(mov.getData());
			int year = cal.get(Calendar.YEAR);
			
			if(ano == year) {
				movimentacoesAno.add(mov);
			}
		}
		
		return movimentacoesAno;
	}
	
	public ArrayList<Movimentacao> getMovimentacoesMes(int mes, int ano) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> movimentacoesMes = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
	
			cal.setTime(mov.getData());
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);
			
			if(month == mes  && ano == year) {
				movimentacoesMes.add(mov);
			}
		}
		
		return movimentacoesMes;
	}
	
	public ArrayList<Movimentacao> getGastosMes(int mes, int ano) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> gastosMes = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
			
			if(mov.getTipoMovimentacao() != TipoMovimentacao.GASTO) {
				continue;
			}
			
			cal.setTime(mov.getData());
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);
			
			if(month == mes  && ano == year) {
				gastosMes.add(mov);
			}
		}
		
		return gastosMes;
	}
	
	public ArrayList<Movimentacao> getGanhosMes(int mes, int ano) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> ganhosMes = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
			
			if(mov.getTipoMovimentacao() != TipoMovimentacao.GANHO) {
				continue;
			}
		
			cal.setTime(mov.getData());
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);
			
			if(month == mes && year == ano) {
				ganhosMes.add(mov);
			}
		}
		return ganhosMes;
	}
	
	public ArrayList<Movimentacao> getGastosAno(int ano) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> gastosMes = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
			
			if(mov.getTipoMovimentacao() != TipoMovimentacao.GASTO) {
				continue;
			}
			
			cal.setTime(mov.getData());
			int year = cal.get(Calendar.YEAR);
			
			if(ano == year) {
				gastosMes.add(mov);
			}
		}
		
		return gastosMes;
	}
	
	public ArrayList<Movimentacao> getGanhosAno(int ano) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<Movimentacao> ganhosMes = new ArrayList<Movimentacao>();
		for(Movimentacao mov: this.movimentacoes) {
			
			if(mov.getTipoMovimentacao() != TipoMovimentacao.GANHO) {
				continue;
			}
		
			cal.setTime(mov.getData());
			int year = cal.get(Calendar.YEAR);
			
			if(year == ano) {
				ganhosMes.add(mov);
			}
		}
		return ganhosMes;
	}
	
	public int getNovaMovimentacaoId(){
		return this.movimentacoes.size();
	}

	@Override
	public void salvarDados() {
		
		try {
			
			Calendar cal = Calendar.getInstance();
			FileWriter csvWriter = new FileWriter("movimentacao.csv");
			for(Movimentacao mov: this.movimentacoes) {
				
				cal.setTime(mov.getData());
				String dataString = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "/";
				dataString += String.valueOf(cal.get(Calendar.MONTH) + 1) + "/";
				dataString += String.valueOf(cal.get(Calendar.YEAR));
				
				csvWriter.append(mov.getId());
				csvWriter.append(",");
				csvWriter.append(dataString);
				csvWriter.append(",");
				csvWriter.append(mov.getCategoriaId());
				csvWriter.append(",");
				csvWriter.append(String.valueOf(mov.getValorMovimentacao()));
				csvWriter.append(",");

				if(mov.getTipoMovimentacao() == TipoMovimentacao.GASTO) {
					csvWriter.append("0");
					
				} else {
					csvWriter.append("1");
				}
				
				csvWriter.append("\n");
			}
			
			csvWriter.flush();
			csvWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void lerDados() {
		String row;
		BufferedReader csvReader = null;
		
		try {
			csvReader = new BufferedReader(new FileReader("movimentacao.csv"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    
			    Movimentacao movimentacao = new Movimentacao();
			    movimentacao.setId(data[0]);
			    
			    try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data[1]);
					movimentacao.setData(date);
					
				} catch (ParseException e) {
					e.printStackTrace();
					return;
				}
			    
			    movimentacao.setCategoriaId(data[2]);
			    movimentacao.setValorMovimentacao(Double.valueOf(data[3]));
			    
			    if(data[4].equals("0")) {
			    	movimentacao.setTipoMovimentacao(TipoMovimentacao.GASTO);
			    	
			    } else {
			    	movimentacao.setTipoMovimentacao(TipoMovimentacao.GANHO);
			    }
			    
			    this.salvarMovimentacao(movimentacao);  
			}
			
			csvReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
