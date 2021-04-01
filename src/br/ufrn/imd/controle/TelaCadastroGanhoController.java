package br.ufrn.imd.controle;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.ufrn.imd.dao.CategoriaDAO;
import br.ufrn.imd.dao.MovimentacaoDAO;
import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.Movimentacao;
import br.ufrn.imd.modelo.TipoMovimentacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TelaCadastroGanhoController {

	private Stage cadastroGanhoStage;
	
    @FXML
    private TextField idCategoria;

    @FXML
    private TextField valorGanho;

    @FXML
    private DatePicker dataGanho;
    
    @FXML
    private Button btnCadastrar;

    @FXML
    void setData(InputMethodEvent event) {

    }

    @FXML
    void setIdCategoria(KeyEvent event) {

    }

    @FXML
    void setValorGanho(KeyEvent event) {

    }
    
    @FXML
    void cadastrar(ActionEvent event) {
    	
    	LocalDate localDate = dataGanho.getValue();
    	Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    	Date date = Date.from(instant);
    	
    	CategoriaDAO categoriaDao = CategoriaDAO.getInstancia();
    	MovimentacaoDAO movimentacaoDao = MovimentacaoDAO.getInstancia();
    	Categoria categoria = categoriaDao.getCategoria(this.idCategoria.getText());
    	
    	if(categoria == null) {
    		return;
    	}
    	
    	Movimentacao ganho = new Movimentacao();
    	ganho.setTipoMovimentacao(TipoMovimentacao.GANHO);
    	ganho.setCategoriaId(categoria.getId());
    	ganho.setId(String.valueOf(movimentacaoDao.getNovaMovimentacaoId()));
    	ganho.setData(date);
    	ganho.setValorMovimentacao(Double.valueOf(valorGanho.getText()));

    	this.valorGanho.setText("");
    	this.idCategoria.setText("");

    }
    
    public void setCadastroGanhoStage(Stage cadastroGanhoStage) {
		this.cadastroGanhoStage = cadastroGanhoStage;
	}

}
