/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AutoEletrica.modelo;

/**
 *
 * @author Cleiton
 */
public class ModeloProdutos {
    private int id_produto;
    private String nome_produto;
    private int quantidade_produto;
    private float imposto_produto;
    private float precoCompra_produto;
    private float precoVenda_produto;
    private int estoqueMin_produto;
    private int estoqueMax_produto;
    private String id_fornecedor;
    private String nome_fornecedor;
    private String pesquisa;

    public int getId_produto() {
	return id_produto;
    }
    public void setId_produto(int id_produto) {
	this.id_produto = id_produto;
    }
    public String getNome_produto() {
	return nome_produto;
    }
    public void setNome_produto(String nome_produto) {
	this.nome_produto = nome_produto;
    }
    public int getQuantidade_produto() {
	return quantidade_produto;
    }
    public void setQuantidade_produto(int quantidade_produto) {
	this.quantidade_produto = quantidade_produto;
    }
    public float getImposto_produto() {
	return imposto_produto;
    }
    public void setImposto_produto(float imposto_produto) {
	this.imposto_produto = imposto_produto;
    }
    public float getPrecoCompra_produto() {
	return precoCompra_produto;
    }
    public void setPreocCompra_produto(float preocCompra_produto) {
	this.precoCompra_produto = preocCompra_produto;
    }
    public float getPrecoVenda_produto() {
	return precoVenda_produto;
    }
    public void setPrecoVenda_produto(float precoVenda_produto) {
	this.precoVenda_produto = precoVenda_produto;
    }
    public int getEstoqueMin_produto() {
	return estoqueMin_produto;
    }
    public void setEstoqueMin_produto(int estoqueMin_produto) {
	this.estoqueMin_produto = estoqueMin_produto;
    }
    public int getEstoqueMax_produto() {
	return estoqueMax_produto;
    }
    public void setEstoqueMax_produto(int estoqueMax_produto) {
	this.estoqueMax_produto = estoqueMax_produto;
    }
    public String getId_fornecedor() {
	return id_fornecedor;
    }
    public void setId_fornecedor(String id_fornecedor) {
	this.id_fornecedor = id_fornecedor;
    }
    public String getNome_fornecedor() {
	return nome_fornecedor;
    }
    public void setNome_fornecedor(String nome_fornecedor) {
	this.nome_fornecedor = nome_fornecedor;
    }

    public String getPesquisa() {
	return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
	this.pesquisa = pesquisa;
    }
    
}
