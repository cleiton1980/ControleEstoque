/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleEstoque.controle;

import br.com.ControleEstoque.dal.ConexaoBD;
import br.com.ControleEstoque.modelo.ModeloCidades;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControleCidades {

    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexEstado = new ConexaoBD();
    ModeloCidades mod = new ModeloCidades();
    int id_estado;
    String nomeEstado;

      public void buscarEstado(String nome){
	conex.Conexao();
	conex.executaSql("select * from estado where nome_estado='" +nome+ "'");
	try {
	    conex.rs.first();
	    id_estado = conex.rs.getInt("id_estado");
	} catch (SQLException ex) {
	   JOptionPane.showMessageDialog(null,"Erro ao tentar buscar um novo estado" + ex);
	}
	conex.desconecta();
    }// FIM DO METODO
      
    public void buscarNomeEstado(int id){
	conexEstado.Conexao();
	conexEstado.executaSql("select * from estado where id_estado="+id);
	
	try {
	    conexEstado.rs.first();
	    nomeEstado = conexEstado.rs.getString("nome_estado");
	} catch (SQLException ex) {
	     JOptionPane.showMessageDialog(null,"Erro ao tentar buscar um novo estado" + ex);
	}	
	conexEstado.desconecta();
    }// FIM DO METODO
    
    
    public void AdicionarCidade(ModeloCidades mod) {
	buscarEstado(mod.getNome_estado());
	conex.Conexao();
	try {
	    PreparedStatement pst = conex.conn.prepareStatement("insert into cidade (nome_cidade,id_estadof)values(?,?)");
	    pst.setString(1, mod.getNome_cidade());
	    pst.setString(2, Integer.toString(id_estado));
	    pst.execute();
	    JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao inserir um registro" + ex);
	}
	conex.desconecta();

    }// FIM DO MÉTODO 

    public void ExcluirCidade(ModeloCidades mod) {
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		PreparedStatement pst = conex.conn.prepareStatement("delete from cidade where id_cidade=?");
		pst.setInt(1, mod.getId_cidade());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao realizar a exclusão" + ex);
	    }
	    conex.desconecta();
	}

    }// FIM DO METODO

    public void EditarCidades(ModeloCidades mod) {
	buscarEstado(mod.getNome_estado());
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		PreparedStatement pst = (PreparedStatement) conex.conn.prepareStatement("update cidade set nome_cidade=?,id_estadof=? where id_cidade=?");
		pst.setString(1, mod.getNome_cidade());
		pst.setString(2, Integer.toString(id_estado));
		pst.setInt(3, mod.getId_cidade());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar um registro" + ex);
	    }
	    conex.desconecta();
	}
    }// FIM DO METODO

    public ModeloCidades pesquisarCidades(ModeloCidades modelo) {
	conex.Conexao();
	conex.executaSql("select * from cidade inner join estado on id_estadof=id_estado where nome_cidade like '%" + modelo.getPesquisa() + "%'");
	try {
	    conex.rs.first();
	    mod.setId_cidade(conex.rs.getInt("id_cidade"));
	    mod.setNome_cidade(conex.rs.getString("nome_cidade"));
	    mod.setNome_estado(conex.rs.getString("nome_estado"));
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Registro não encontrado");
	}
	conex.desconecta();
	return mod;

    }// FIM DO METODO

}//FIM DA CLASSE
