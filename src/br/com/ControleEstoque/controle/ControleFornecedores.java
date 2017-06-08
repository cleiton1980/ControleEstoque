/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleEstoque.controle;

import br.com.ControleEstoque.dal.ConexaoBD;
import br.com.ControleEstoque.modelo.ModeloFornecedores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControleFornecedores {

    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexBairro = new ConexaoBD();
    ModeloFornecedores mod = new ModeloFornecedores();
    int id_bairro;
    String nomeBairro;

    public void buscarBairro(String nome) {
	conex.Conexao();
	try {
	    conex.executaSql("select * from bairro where nome_bairro='" + nome + "'");
	    conex.rs.first();
	    id_bairro = conex.rs.getInt("id_bairro");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um novo bairro" + ex);
	}
	conex.desconecta();
    }// FIM DO METODO

    public void AdicionarFornecedores(ModeloFornecedores mod) {
	buscarBairro(mod.getNome_bairro());
	conex.Conexao();
	try {
	    PreparedStatement pst = conex.conn.prepareStatement("insert into tbfornecedores (nome_fornecedor,endereco_fornecedor,numero_fornecedor,cnpj_fornecedor,telefone1_fornecedor,telefone2_fornecedor,id_bairrof)values(?,?,?,?,?,?,?)");
	    pst.setString(1, mod.getNome_fornecedor());
	    pst.setString(2, mod.getEndereco_fornecedor());
	    pst.setString(3, mod.getNumero_fornecedor());
	    pst.setString(4, mod.getCnpj_fornecedor());
	    pst.setString(5, mod.getTelefone1_fornecedor());
	    pst.setString(6, mod.getTelefone2_fornecedor());
	    pst.setInt(7, id_bairro);
	    pst.execute();
	    JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao inserir um registro" + ex);
	}
	conex.desconecta();
    }// FIM DO METODO

    public void ExcluirFornecedores(ModeloFornecedores mod) {
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		PreparedStatement pst = conex.conn.prepareStatement("delete from tbfornecedores where id_fornecedor=?");
		pst.setInt(1, mod.getId_fornecedor());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao realizar a exclusão" + ex);
	    }
	    conex.desconecta();
	}

    }// FIM DO METODO

    public void EditarFornecedor(ModeloFornecedores mod) {
	buscarBairro(mod.getNome_bairro());
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		PreparedStatement pst = (PreparedStatement) conex.conn.prepareStatement("update tbfornecedores set nome_fornecedor=?,endereco_fornecedor=?,numero_fornecedor=?,cnpj_fornecedor=?,telefone1_fornecedor=?,telefone2_fornecedor=?, id_bairrof=? where id_fornecedor=?");
		pst.setString(1, mod.getNome_fornecedor());
		pst.setString(2, mod.getEndereco_fornecedor());
		pst.setString(3, mod.getNumero_fornecedor());
		pst.setString(4, mod.getCnpj_fornecedor());
		pst.setString(5, mod.getTelefone1_fornecedor());
		pst.setString(6, mod.getTelefone2_fornecedor());
		pst.setString(7, Integer.toString(id_bairro));
		pst.setInt(8, mod.getId_fornecedor());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar um registro" + ex);
	    }
	    conex.desconecta();
	}
    }// FIM DO METODO

    public ModeloFornecedores pesquisarFornecedores(ModeloFornecedores modelo) {
	conex.Conexao();
	conex.executaSql("select * from tbfornecedores inner join bairro on id_bairrof=id_bairro inner join cidade on id_cidadef = id_cidade inner join estado on id_estadof = id_estado where nome_fornecedor like '%" + modelo.getPesquisa() + "%'");
	try {
	    conex.rs.first();
	    mod.setId_fornecedor(conex.rs.getInt("id_fornecedor"));
	    mod.setNome_fornecedor(conex.rs.getString("nome_fornecedor"));
	    mod.setEndereco_fornecedor(conex.rs.getString("endereco_fornecedor"));
	    mod.setEndereco_fornecedor(conex.rs.getString("numero_fornecedor"));
	    mod.setCnpj_fornecedor(conex.rs.getString("cnpj_fornecedor"));
	    mod.setTelefone1_fornecedor(conex.rs.getString("telefone1_fornecedor"));
	    mod.setTelefone2_fornecedor(conex.rs.getString("telefone2_fornecedor"));
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
