/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleEstoque.modelo;

/**
 *
 * @author Cleiton
 */
public class ModeloFornecedores {
    
    private int id_fornecedor;
    private int id_cidade;
    private int id_estado;
    private String nome_fornecedor;
    private String endereco_fornecedor;
    private String numero_fornecedor;
    private String cnpj_fornecedor;
    private String telefone1_fornecedor;
    private String telefone2_fornecedor;   
    private String nome_bairro;
    private String nome_cidade; 
    private String nome_estado;
    private String pesquisa;

    public int getId_fornecedor() {
	return id_fornecedor;
    }
    public void setId_fornecedor(int id_fornecedor) {
	this.id_fornecedor = id_fornecedor;
    }
    public String getNome_fornecedor() {
	return nome_fornecedor;
    }
    public void setNome_fornecedor(String nome_fornecedor) {
	this.nome_fornecedor = nome_fornecedor;
    }
    public String getEndereco_fornecedor() {
	return endereco_fornecedor;
    }
    public void setEndereco_fornecedor(String endereco_fornecedor) {
	this.endereco_fornecedor = endereco_fornecedor;
    }
    public String getCnpj_fornecedor() {
	return cnpj_fornecedor;
    }
    public void setCnpj_fornecedor(String cnpj_fornecedor) {
	this.cnpj_fornecedor = cnpj_fornecedor;
    }
    public String getTelefone1_fornecedor() {
	return telefone1_fornecedor;
    }
    public void setTelefone1_fornecedor(String telefone1_fornecedor) {
	this.telefone1_fornecedor = telefone1_fornecedor;
    }
    public String getTelefone2_fornecedor() {
	return telefone2_fornecedor;
    }
    public void setTelefone2_fornecedor(String telefone2_fornecedor) {
	this.telefone2_fornecedor = telefone2_fornecedor;
    }   
    public String getPesquisa() {
	return pesquisa;
    }
    public void setPesquisa(String pesquisa) {
	this.pesquisa = pesquisa;
    }
    public int getId_cidade() {
	return id_cidade;
    }
    public void setId_cidade(int id_cidade) {
	this.id_cidade = id_cidade;
    }
    public int getId_estado() {
	return id_estado;
    }
    public void setId_estado(int id_estado) {
	this.id_estado = id_estado;
    }
    public String getNome_bairro() {
	return nome_bairro;
    }
    public void setNome_bairro(String nome_bairro) {
	this.nome_bairro = nome_bairro;
    }
    public String getNome_cidade() {
	return nome_cidade;
    }
    public void setNome_cidade(String nome_cidade) {
	this.nome_cidade = nome_cidade;
    }
    public String getNome_estado() {
	return nome_estado;
    }
    public void setNome_estado(String nome_estado) {
	this.nome_estado = nome_estado;
    }       

    public String getNumero_fornecedor() {
	return numero_fornecedor;
    }

    public void setNumero_fornecedor(String numero_fornecedor) {
	this.numero_fornecedor = numero_fornecedor;
    }
}
