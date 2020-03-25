package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * @author Michael
 *
 */

@Entity
@Table(name = "empresa")

public class Empresa implements Serializable{
	/**
	 * Serializacao da Classe
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ID da Tabela
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empresa")
	private Long id;
	
	/**
	 * CNPJ da empresa
	 */
	@NotNull
	@Column(name = "cnpj")
	private String cnpj;
	
	/**
	 * Nome da empresa
	 */
	@NotNull
	@Column(name = "nome_empresa")
	private String nome;
	
	/**
	 * Contato da empresa
	 */
	@NotNull
	@Column(name = "contato")
	private String contato;
	
	
	/**
	 * Email da Empresa
	 */
	@NotNull
	@Column(name = "email")
	private String email;
	
	/**
	 * Tipo da empresa
	 */
	@NotNull
	@Column(name = "tipo_empresa")
	private String tipo_empresa;
	
	/**
	 * Razão da empresa
	 */
	@NotNull
	@Column(name = "razao_social")
	private String razao_social;
	
	/**
	 * CEP da empresa
	 */
	@NotNull
	@Column(name = "cep")
	private String cep;
	
	/**
	 * Estado da empresa
	 */
	@NotNull
	@Column(name = "estado")
	private String estado;
	
	/**
	 * Cidade da empresa
	 */
	@NotNull
	@Column(name = "cidade")
	private String cidade;
	
	/**
	 * Bairro da empresa
	 */
	@NotNull
	@Column(name = "bairro")
	private String bairro;
	
	/**
	 * Logradouro da empresa
	 */
	@NotNull
	@Column(name = "logradouro")
	private String logradouro;
	
	/**
	 * Complemnto do endereço da empresa
	 */
	@NotNull
	@Column(name = "complemento")
	private String complemento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo_empresa() {
		return tipo_empresa;
	}

	public void setTipo_empresa(String tipo_empresa) {
		this.tipo_empresa = tipo_empresa;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



}
