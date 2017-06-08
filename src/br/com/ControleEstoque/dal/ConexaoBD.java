/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleEstoque.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ConexaoBD {
    public Statement stm;//Realiza a pesquisa no Banco de Dados
    public ResultSet rs; //Armazena o resultado da pesquisa no banco de dados
    private String driver = "com.mysql.jdbc.Driver";
    //private String caminho = "jdbc:mysql://192.168.1.38:3306/autoeletrica";
  private String caminho = "jdbc:mysql://192.168.1.38:3306/autoeletrica"; 
    private String usuario = "cleiton";
    private String senha = "dnv8294moto";
    public Connection conn;

    public void Conexao() {

	try {
	    System.setProperty("jdbc.Drivers", driver);
	    conn = DriverManager.getConnection(caminho, usuario, senha);
	    // JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao realizar a conexão com o Banco de Dados\n  " + ex);
	}
    }//FIM DO METODO

    public void executaSql(String sql){
	try {
	    stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
	    rs = stm.executeQuery(sql);
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro no executaSql\n  " + ex.getMessage());
	}
    
    }//FIM DO METODO
    
    public void desconecta() {
	try {
	    conn.close();
	   // JOptionPane.showMessageDialog(null, "Desconectado com sucesso");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao tentar se desconectar com o Banco de Dados\n  " + ex);
	}
    }//FIM DO METODO

}//FIM DA CLASSE

