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
public class ModeloEstados {
    private int id_estado;
    private String nome_estado;
    private String sigla_estado;
    private String pesquisa;

    public ModeloEstados(int id_estado, String nome_estado, String sigla_estado) {
	this.id_estado = id_estado;
	this.nome_estado = nome_estado;
	this.sigla_estado = sigla_estado;
    }
    public ModeloEstados() {	
    }
    public int getId_estado() {
	return id_estado;
    }
    public void setId_estado(int id_estado) {
	this.id_estado = id_estado;
    }
    public String getNome_estado() {
	return nome_estado;
    }
    public void setNome_estado(String nome_estado) {
	this.nome_estado = nome_estado;
    }
    public String getSigla_estado() {
	return sigla_estado;
    }
    public void setSigla_estado(String sigla_estado) {
	this.sigla_estado = sigla_estado;
    } 

    public String getPesquisa() {
	return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
	this.pesquisa = pesquisa;
    }
    
}
