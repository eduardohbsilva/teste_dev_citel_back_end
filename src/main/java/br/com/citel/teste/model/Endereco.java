package br.com.citel.teste.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "logradouro")
    private String logradouro;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "bairro")
    private String bairro;
    
    @Column(name = "cidade")
    private String cidade;
    
    @Column(name = "estado")
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Endereco id(Long id) {
		this.id = id;
		return this;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Endereco cep(String cep) {
		this.cep = cep;
		return this;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public Endereco logradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Endereco numero(Integer numero) {
		this.numero = numero;
		return this;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public Endereco bairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Endereco cidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Endereco estado(String estado) {
		this.estado = estado;
		return this;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
