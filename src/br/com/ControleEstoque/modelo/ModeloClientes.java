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
public class ModeloClientes {
    private int id_cliente;
    private String nome_cliente;
    private String endereco_cliente;
    private String numero_cliente;
    private String rg_cliente;
    private String cpf_cliente;
    private String celular_cliente;
    private String telefone_cliente;
    private int id_bairro;
    private String nome_bairro;
    private String nome_cidade;
    private String nome_estado;
    private int id_cidade;
    private int id_estado;
    private String pesquisa;

    public int getId_cliente() {
	return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
	this.id_cliente = id_cliente;
    }
    public String getNome_cliente() {
	return nome_cliente;
    }
    public void setNome_cliente(String nome_cliente) {
	this.nome_cliente = nome_cliente;
    }
    public String getEndereco_cliente() {
	return endereco_cliente;
    }
    public void setEndereco_cliente(String endereco_cliente) {
	this.endereco_cliente = endereco_cliente;
    }
    public String getRg_cliente() {
	return rg_cliente;
    }
    public void setRg_cliente(String rg_cliente) {
	this.rg_cliente = rg_cliente;
    }
    public String getCpf_cliente() {
	return cpf_cliente;
    }
    public void setCpf_cliente(String cpf_cliente) {
	this.cpf_cliente = cpf_cliente;
    }
    public String getCelular_cliente() {
	return celular_cliente;
    }
    public void setCelular_cliente(String celular_cliente) {
	this.celular_cliente = celular_cliente;
    }
    public String getTelefone_cliente() {
	return telefone_cliente;
    }
    public void setTelefone_cliente(String telefone_cliente) {
	this.telefone_cliente = telefone_cliente;
    }
    public int getId_bairro() {
	return id_bairro;
    }
    public void setId_bairro(int id_bairro) {
	this.id_bairro = id_bairro;
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
    public String getPesquisa() {
	return pesquisa;
    }
    public void setPesquisa(String pesquisa) {
	this.pesquisa = pesquisa;
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

    public String getNumero_cliente() {
	return numero_cliente;
    }

    public void setNumero_cliente(String numero_cliente) {
	this.numero_cliente = numero_cliente;
    }
}
