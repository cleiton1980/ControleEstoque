    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleEstoque.controle;

import br.com.ControleEstoque.dal.ConexaoBD;
import br.com.ControleEstoque.modelo.ModeloBairros;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControleBairros {

    ConexaoBD conex = new ConexaoBD();
    ModeloBairros mod = new ModeloBairros();
    ConexaoBD conexCidade = new ConexaoBD();
    int id_cidade;
    String nomeCidade;

    public void buscarCidade(String nome) {
	conex.Conexao();
	conex.executaSql("select * from cidade where nome_cidade='" + nome + "'");
	try {
	    conex.rs.first();
	    id_cidade = conex.rs.getInt("id_cidade");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao tentar buscar uma nova cidade" + ex);
	}
	conex.desconecta();
    }// FIM DO METODO

    public void buscarNomeCidade(int id) {
	conexCidade.Conexao();
	conexCidade.executaSql("select * from cidade where id_cidade=" + id);

	try {
	    conexCidade.rs.first();
	    nomeCidade = conexCidade.rs.getString("nome_cidade");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao tentar buscar uma nova cidade" + ex);
	}
	conexCidade.desconecta();
    }// FIM DO METODO
    public void preencherBairros() {
	conex.Conexao();

	try {
	    PreparedStatement pst = conex.conn.prepareStatement("select nome_bairro from bairro order by nome_bairro");
	    pst.setString(1, mod.getNome_bairro());
	    pst.execute();	   
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao preencher a combobox bairro" + ex);
	}
	conex.desconecta();
    }// FIM DO METODO

    public void AdicionarBairro(ModeloBairros mod) {
	buscarCidade(mod.getNome_cidade());
	conex.Conexao();
	try {
	    PreparedStatement pst = conex.conn.prepareStatement("insert into bairro (nome_bairro,id_cidadef)values(?,?)");
	    pst.setString(1, mod.getNome_bairro());
	    pst.setString(2, Integer.toString(id_cidade));
	    pst.execute();
	    JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Erro ao inserir um registro" + ex);
	}
	conex.desconecta();
    }// FIM DO METODO

    public void ExcluirBairros(ModeloBairros mod) {
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		PreparedStatement pst = conex.conn.prepareStatement("delete from bairro where id_bairro=?");
		pst.setInt(1, mod.getId_bairro());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao realizar a exclusão" + ex);
	    }
	    conex.desconecta();
	}

    }// FIM DO METODO

    public void EditarBairros(ModeloBairros mod) {
	buscarCidade(mod.getNome_cidade());
	conex.Conexao();
	int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar este registro", "Atenção", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION) {
	    try {
		PreparedStatement pst = (PreparedStatement) conex.conn.prepareStatement("update bairro set nome_bairro=?,id_cidadef=? where id_bairro=?");
		pst.setString(1, mod.getNome_bairro());
		pst.setString(2, Integer.toString(id_cidade));
		pst.setInt(3, mod.getId_bairro());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar um registro" + ex);
	    }
	    conex.desconecta();
	}
    }// FIM DO METODO

    public ModeloBairros pesquisarBairros(ModeloBairros modelo) {
	conex.Conexao();
	conex.executaSql("select * from bairro inner join cidade on id_cidadef=id_cidade where nome_bairro like '%" + modelo.getPesquisa() + "%'");
	try {
	    conex.rs.first();
	    mod.setId_bairro(conex.rs.getInt("id_bairro"));
	    mod.setNome_bairro(conex.rs.getString("nome_bairro"));
	    mod.setNome_cidade(conex.rs.getString("nome_cidade"));
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, "Registro não encontrado");
	}
	conex.desconecta();
	return mod;

    }// FIM DO METODO

}
