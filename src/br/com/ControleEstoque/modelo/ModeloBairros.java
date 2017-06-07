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
public class ModeloBairros {

    private int id_bairro;
    private String nome_bairro;
    private String id_cidade;
    private String nome_cidade;
    private String pesquisa;

    public ModeloBairros() {
    }   
    public int getId_bairro() {
	return id_bairro;
    }
    public void setId_bairro(int id_bairro) {
	this.id_bairro = id_bairro;
    }
    public String getNome_bairro() {
	return nome_bairro;
    }
    public void setNome_bairro(String nome_bairro) {
	this.nome_bairro = nome_bairro;
    }
    public String getPesquisa() {
	return pesquisa;
    }
    public void setPesquisa(String pesquisa) {
	this.pesquisa = pesquisa;
    }

    public String getId_cidade() {
	return id_cidade;
    }

    public void setId_cidade(String id_cidade) {
	this.id_cidade = id_cidade;
    } 

    public String getNome_cidade() {
	return nome_cidade;
    }
    public void setNome_cidade(String nome_cidade) {
	this.nome_cidade = nome_cidade;
    }

}
