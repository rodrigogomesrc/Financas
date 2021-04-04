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

public class TelaCadastroGastoController {

	private Stage cadastroGastoStage;
	
    @FXML
    private TextField idCategoria;

    @FXML
    private TextField valorGasto;

    @FXML
    private DatePicker dataGasto;
    
    @FXML
    private Button btnCadastrar;

    @FXML
    void setData(InputMethodEvent event) {
    	//
    }

    @FXML
    void setIdCategoria(KeyEvent event) {
    	//
    }

    @FXML
    void setValorGasto(KeyEvent event) {
    	//
    }
    
    @FXML
    void cadastrar(ActionEvent event) {
    	
    	LocalDate localDate = dataGasto.getValue();
    	Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    	Date date = Date.from(instant);
    	
    	CategoriaDAO categoriaDao = CategoriaDAO.getInstancia();
    	MovimentacaoDAO movimentacaoDao = MovimentacaoDAO.getInstancia();
    	Categoria categoria = categoriaDao.getCategoria(this.idCategoria.getText());
    	
    	if(categoria == null || categoria.getTipoCategoria() == TipoMovimentacao.GANHO) {
    		return;
    	}
    	
    	Movimentacao gasto = new Movimentacao();
    	gasto.setTipoMovimentacao(TipoMovimentacao.GASTO);
    	gasto.setCategoriaId(categoria.getId());
    	gasto.setId(String.valueOf(movimentacaoDao.getNovaMovimentacaoId()));
    	gasto.setData(date);
    	gasto.setValorMovimentacao(Double.valueOf(valorGasto.getText()));
    	movimentacaoDao.salvarMovimentacao(gasto);

    	this.valorGasto.setText("");
    	this.idCategoria.setText("");

    }
    
    public void setCadastroGanhoStage(Stage cadastroGastoStage) {
		this.cadastroGastoStage = cadastroGastoStage;
	}

}