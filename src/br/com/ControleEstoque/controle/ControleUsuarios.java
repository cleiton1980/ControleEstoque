/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleEstoque.controle;

import br.com.ControleEstoque.dal.ConexaoBD;
import br.com.ControleEstoque.modelo.ModeloUsuarios;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControleUsuarios {

    ConexaoBD conex = new ConexaoBD();
    ModeloUsuarios mod = new ModeloUsuarios();

    public void Adicionar(ModeloUsuarios mod) {
	conex.Conexao();
	try {
	    PreparedStatement pst = (PreparedStatement) conex.conn.prepareStatement("insert into tbusuarios(nome_usuario,login,perfil,senha) values (?,?,?,?)");
	    pst.setString(1, mod.getNome_usuario());
	    pst.setString(2, mod.getLogin());
	    pst.setString(3, mod.getPerfil_usuario());
	    pst.setString(4, mod.getSenha_usuario());
	    pst.execute();
	    JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar um Usuario" + ex);
	}
	conex.desconecta();
    }//FIM DO METODO

    public void Excluir(ModeloUsuarios mod) {
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {

	    try {
		PreparedStatement pst = (PreparedStatement) conex.conn.prepareStatement("delete from tbusuarios where id_usuario=?");
		pst.setInt(1, mod.getId_usuario());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao tentar excluir um registro" + ex);
	    }
	}
	conex.desconecta();
    }//FIM DO METODO

    public ModeloUsuarios pesquisarUsuarios(ModeloUsuarios modelo) {
	conex.Conexao();
	conex.executaSql("select * from tbusuarios where nome_usuario like '%" + modelo.getPesquisa() + "%'");
	try {
	    conex.rs.first();
	    mod.setId_usuario(conex.rs.getInt("id_usuario"));
	    mod.setNome_usuario(conex.rs.getString("nome_usuario"));
	    mod.setLogin(conex.rs.getString("login"));
	    mod.setPerfil_usuario(conex.rs.getString("perfil"));
	    mod.setSenha_usuario(conex.rs.getString("senha"));

	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Registro não encontrado");
	}
	conex.desconecta();
	return mod;

    }// FIM DO METODO

    public void editarMedicos(ModeloUsuarios mod) {
	conex.Conexao();
	try {
	    PreparedStatement pst = (PreparedStatement) conex.conn.prepareStatement("update tbusuarios set nome_usuario=?,login=?,perfil=?,senha=? where id_usuario=?");
	    pst.setString(1, mod.getNome_usuario());
	    pst.setString(2, mod.getLogin());
	    pst.setString(3, mod.getPerfil_usuario());
	    pst.setString(4, mod.getSenha_usuario());
	    pst.setInt(5, mod.getId_usuario());
	    pst.execute();
	    JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar um registro" + ex);
	}
	conex.desconecta();

    }
}
