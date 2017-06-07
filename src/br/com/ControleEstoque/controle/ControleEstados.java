/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleEstoque.controle;

import br.com.ControleEstoque.dal.ConexaoBD;
import br.com.ControleEstoque.modelo.ModeloEstados;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControleEstados {

    //1º CONEXAO COM O BANCO DE DADOS
    ConexaoBD conex = new ConexaoBD();
    ModeloEstados mod = new ModeloEstados();

    //2º CRIAR O METODOS
    public void AdicionarEstado(ModeloEstados mod) {
	conex.Conexao();
	try {
	    PreparedStatement pst = conex.conn.prepareStatement("insert into estado (nome_estado,sigla_estado)values(?,?)");
	    pst.setString(1, mod.getNome_estado());
	    pst.setString(2, mod.getSigla_estado());
	    pst.execute();
	    JOptionPane.showMessageDialog(null, "Estado cadastrado com sucesso");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Estado cadastrar um estado" + ex);
	}
	conex.desconecta();
    }// FIM DO MÉTODO 

    public void ExcluirEstado(ModeloEstados mod) {
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		PreparedStatement pst = conex.conn.prepareStatement("delete from estado where id_estado=?");
		pst.setInt(1, mod.getId_estado());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao realizar a exclusão de um estado" + ex);
	    }
	    conex.desconecta();
	}
    }// FIM DO METODO
    
       public void editarEstados(ModeloEstados mod){
       conex.Conexao();
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	try {
	    PreparedStatement pst = (PreparedStatement) conex.conn.prepareStatement("update estado set nome_estado=?,sigla_estado=? where id_estado=?");
	    pst.setString(1, mod.getNome_estado());
	    pst.setString(2, mod.getSigla_estado());
	    pst.setInt(3, mod.getId_estado());
	    pst.execute();
	    JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar um registro" + ex);  
	}
       conex.desconecta();
      }
       }
     public ModeloEstados pesquisarEstados(ModeloEstados modelo) {
	conex.Conexao();
	conex.executaSql("select * from estado where nome_estado like '%" +modelo.getPesquisa()+ "%'");	
	try {
	   conex.rs.first();
	   mod.setId_estado(conex.rs.getInt("id_estado"));
	   mod.setNome_estado(conex.rs.getString("nome_estado"));
	   mod.setSigla_estado(conex.rs.getString("sigla_estado"));
	} catch (SQLException ex) {
	  JOptionPane.showMessageDialog(null, "Registro não encontrado");   
	}
	conex.desconecta();
	return mod;
	
    }// FIM DO METODO
    

}//FIM DA CLASSE
