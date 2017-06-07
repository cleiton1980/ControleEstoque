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
public class ModeloCidades {
    private int id_cidade;
    private String nome_cidade;
    private int id_estado;
    private String nome_estado;
    private String pesquisa;
    
    public ModeloCidades() {	
    }
    public int getId_cidade() {
	return id_cidade;
    }
    public void setId_cidade(int id_cidade) {
	this.id_cidade = id_cidade;
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
    public String getPesquisa() {
	return pesquisa;
    }
    public void setPesquisa(String pesquisa) {
	this.pesquisa = pesquisa;
    }
    public int getId_estado() {
	return id_estado;
    }
    public void setId_estado(int id_estado) {
	this.id_estado = id_estado;
    }
}//FIM DO METODO
