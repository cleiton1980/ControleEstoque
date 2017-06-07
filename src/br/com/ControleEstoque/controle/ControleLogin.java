/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleEstoque.controle;

import br.com.ControleEstoque.dal.ConexaoBD;
import br.com.ControleEstoque.modelo.ModeloLogin;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControleLogin {
    
    ConexaoBD conex = new ConexaoBD();
    ModeloLogin mod = new ModeloLogin();
    
public void logar(){
conex.Conexao();
	try {
	    PreparedStatement pst = (PreparedStatement) conex.conn.prepareStatement("select * from tbusuarios where login=? and senha=?");
	pst.setString(1, mod.getUsuario());
	pst.setString(2,mod.getSenha());
	pst.execute();
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null,"Erro ao logar" +  ex);
	}
conex.desconecta();

} // FIM DO METODO   
    
}// FIM DA CLASSE
