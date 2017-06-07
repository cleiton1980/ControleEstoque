/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleEstoque.controle;

import br.com.ControleEstoque.dal.ConexaoBD;
import br.com.ControleEstoque.modelo.ModeloClientes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControleClientes {

    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexBairro = new ConexaoBD();
    ModeloClientes mod = new ModeloClientes();
    int id_bairro;
    String nomeBairro;

    public void buscarBairro(String nome) {
	conex.Conexao();
	conex.executaSql("select * from bairro where nome_bairro='" + nome + "'");
	try {
	    conex.rs.first();
	    id_bairro = conex.rs.getInt("id_bairro");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um novo bairro" + ex);
	}
	conex.desconecta();
    }// FIM DO METODO

    public void buscarNomeBairro(int id) {
	conexBairro.Conexao();
	conexBairro.executaSql("select * from bairro where id_bairro=" + id);

	try {
	    conexBairro.rs.first();
	    nomeBairro = conexBairro.rs.getString("nome_bairro");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um novo bairro" + ex);
	}
	conexBairro.desconecta();
    }// FIM DO METODO

    
    public void AdicionarClientes(ModeloClientes mod) {
	buscarBairro(mod.getNome_bairro());
	conex.Conexao();
	try {
	    PreparedStatement pst = conex.conn.prepareStatement("insert into tbclientes (nome_cliente,endereco_cliente,numero_cliente,rg_cliente,cpf_cliente,telefone1_cliente,telefone2_cliente,id_bairrof)values(?,?,?,?,?,?,?,?)");
	    pst.setString(1, mod.getNome_cliente());
	    pst.setString(2, mod.getEndereco_cliente());
	    pst.setString(3, mod.getNumero_cliente());
	    pst.setString(4, mod.getRg_cliente());
	    pst.setString(5, mod.getCpf_cliente());
	    pst.setString(6, mod.getCelular_cliente());
	    pst.setString(7, mod.getTelefone_cliente());
	    pst.setString(8, Integer.toString(id_bairro));
	    pst.execute();
	    JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao inserir um registro" + ex);
	}
	conex.desconecta();
    }// FIM DO METODO

    public void ExcluirClientes(ModeloClientes mod) {
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		PreparedStatement pst = conex.conn.prepareStatement("delete from tbclientes where id_cliente=?");
		pst.setInt(1, mod.getId_cliente());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao realizar a exclusão");
	    }
	    conex.desconecta();
	}

    }// FIM DO METODO

    public void EditarClientes(ModeloClientes mod) {
	buscarBairro(mod.getNome_bairro());
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		PreparedStatement pst = (PreparedStatement) conex.conn.prepareStatement("update tbclientes set nome_cliente=?,endereco_cliente=?,numero_cliente=?,rg_cliente=?,cpf_cliente=?,telefone1_cliente=?,telefone2_cliente=?, id_bairrof=? where id_cliente=?");
		pst.setString(1, mod.getNome_cliente());
		pst.setString(2, mod.getEndereco_cliente());
		pst.setString(3, mod.getNumero_cliente());
		pst.setString(4, mod.getRg_cliente());
		pst.setString(5, mod.getCpf_cliente());
		pst.setString(6, mod.getCelular_cliente());
		pst.setString(7, mod.getTelefone_cliente());
		pst.setString(8, Integer.toString(id_bairro));
		pst.setInt(9, mod.getId_cliente());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar um registro" + ex);
	    }
	    conex.desconecta();
	}
    }// FIM DO METODO

    public ModeloClientes pesquisarClientes(ModeloClientes modelo) {
	conex.Conexao();
	conex.executaSql("select * from tbclientes inner join bairro on id_bairrof=id_bairro inner join cidade on id_cidadef = id_cidade inner join estado on id_estadof = id_estado where nome_cliente like '%" + modelo.getPesquisa() + "%'");
	try {
	    conex.rs.first();
	    mod.setId_cliente(conex.rs.getInt("id_cliente"));
	    mod.setNome_cliente(conex.rs.getString("nome_cliente"));
	    mod.setEndereco_cliente(conex.rs.getString("endereco_cliente"));
	    mod.setNumero_cliente(conex.rs.getString("numero_cliente"));
	    mod.setRg_cliente(conex.rs.getString("rg_cliente"));
	    mod.setCpf_cliente(conex.rs.getString("cpf_cliente"));
	    mod.setCelular_cliente(conex.rs.getString("telefone1_cliente"));
	    mod.setTelefone_cliente(conex.rs.getString("telefone2_cliente"));
	    mod.setNome_bairro(conex.rs.getString("nome_bairro"));
	    mod.setNome_cidade(conex.rs.getString("nome_cidade"));
	    mod.setNome_estado(conex.rs.getString("nome_estado"));
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Registro não encontrado");
	}
	conex.desconecta();
	return mod;

    }// FIM DO METODO 
}
