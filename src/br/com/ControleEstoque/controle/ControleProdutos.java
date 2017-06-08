/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleEstoque.controle;

import br.com.ControleEstoque.dal.ConexaoBD;
import br.com.ControleEstoque.modelo.ModeloProdutos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControleProdutos {

    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexFornecedor = new ConexaoBD();
    ModeloProdutos mod = new ModeloProdutos();
    int id_fornecedor;
    String nomeFornecedor;

    public void buscarFornecedor(String nome) {
	conex.Conexao();
	try {
	    conex.executaSql("select * from tbfornecedores where nome_fornecedor='" + nome + "'");
	    conex.rs.first();
	    id_fornecedor = conex.rs.getInt("id_fornecedor");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um novo fornecedor" + ex);
	}
	conex.desconecta();
    }// FIM DO METODO

    public void AdicionarProdutos(ModeloProdutos mod) {
	buscarFornecedor(mod.getNome_fornecedor());
	conex.Conexao();
	try {
	    PreparedStatement pst = conex.conn.prepareStatement("insert into tbprodutos (nome_produto,quantidade_produto,codigo_barras,precoCompra_produto,precoVenda_produto,estoqueMin_produto,estoqueMax_produto,local_produto,id_fornecedorf)values(?,?,?,?,?,?,?,?,?)");
	    pst.setString(1, mod.getNome_produto());
	    pst.setInt(2, mod.getQuantidade_produto());
	    pst.setString(3, mod.getCodigo_barras());
	    pst.setFloat(4, mod.getPrecoCompra_produto());
	    pst.setFloat(5, mod.getPrecoVenda_produto());
	    pst.setInt(6, mod.getEstoqueMin_produto());
	    pst.setInt(7, mod.getEstoqueMax_produto());
	    pst.setString(8, mod.getLocal_produto());
	    pst.setInt(9, id_fornecedor);
	    pst.execute();
	    JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao inserir um registro" + ex);
	}
	conex.desconecta();
    }// FIM DO METODO

    public void ExcluirProdutos(ModeloProdutos mod) {
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		PreparedStatement pst = conex.conn.prepareStatement("delete from tbprodutos where id_produto=?");
		pst.setInt(1, mod.getId_produto());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao realizar a exclusão" + ex);
	    }
	    conex.desconecta();
	}

    }// FIM DO METODO

    public void EditarProdutos(ModeloProdutos mod) {
	buscarFornecedor(mod.getNome_fornecedor());
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		PreparedStatement pst = (PreparedStatement) conex.conn.prepareStatement("update tbprodutos set nome_produto=?,quantidade_produto=?,codigo_barras=?,precoCompra_produto=?,precoVenda_produto=?,estoqueMin_produto=?,estoqueMax_produto=?,local_produto=?, id_fornecedorf=? where id_produto=?");
		pst.setString(1, mod.getNome_produto());
		pst.setInt(2, mod.getQuantidade_produto());
		pst.setString(3, mod.getCodigo_barras());
		pst.setFloat(4, mod.getPrecoCompra_produto());
		pst.setFloat(5, mod.getPrecoVenda_produto());
		pst.setInt(6, mod.getEstoqueMin_produto());
		pst.setInt(7, mod.getEstoqueMax_produto());
		pst.setString(8, mod.getLocal_produto());
		pst.setInt(9, id_fornecedor);
		pst.setInt(10, mod.getId_produto());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar um registro" + ex);
	    }
	    conex.desconecta();
	}
    }// FIM DO METODO

    public ModeloProdutos pesquisarProdutos(ModeloProdutos modelo) {
	conex.Conexao();
	conex.executaSql("select * from tbprodutos inner join tbfornecedores on id_fornecedorf=id_fornecedor where nome_produto like '%" + modelo.getPesquisa() + "%'");
	try {
	    conex.rs.first();
	    mod.setId_produto(conex.rs.getInt("id_produto"));
	    mod.setNome_produto(conex.rs.getString("nome_produto"));
	    mod.setQuantidade_produto(conex.rs.getInt("quantidade_produto"));
	    mod.setCodigo_barras(conex.rs.getString("codigo_barras"));
	    mod.setPrecoCompra_produto(conex.rs.getFloat("precoCompra_produto"));
	    mod.setPrecoVenda_produto(conex.rs.getFloat("precoVenda_produto"));
	    mod.setEstoqueMin_produto(conex.rs.getInt("estoqueMin_produto"));
	    mod.setEstoqueMax_produto(conex.rs.getInt("estoqueMax_produto"));
	    mod.setLocal_produto(conex.rs.getString("local_produto"));
	    mod.setNome_fornecedor(conex.rs.getString("nome_fornecedor"));
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Registro não encontrado");
	}
	conex.desconecta();
	return mod;

    }// FIM DO METODO

}
