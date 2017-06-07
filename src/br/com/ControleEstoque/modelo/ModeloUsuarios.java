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
public class ModeloUsuarios {
  private int id_usuario;
  private String nome_usuario;
  private String senha_usuario;
  private String perfil_usuario;
  private String login; 
  private String pesquisa;

    

    public int getId_usuario() {
	return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
	this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
	return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
	this.nome_usuario = nome_usuario;
    }

    public String getSenha_usuario() {
	return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
	this.senha_usuario = senha_usuario;
    }

    public String getPerfil_usuario() {
	return perfil_usuario;
    }

    public void setPerfil_usuario(String perfil_usuario) {
	this.perfil_usuario = perfil_usuario;
    }

    public String getPesquisa() {
	return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
	this.pesquisa = pesquisa;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }
 
  
  
}//FIM DA CLASSE
