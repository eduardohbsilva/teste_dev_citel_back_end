package br.com.citel.teste.service.dto;

public class EnderecoDTO {

    private Long id;

    private String cep;

    private String logradouro;
    
    private Integer numero;
    
    private String bairro;
    
    private String cidade;
    
    private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public EnderecoDTO id(Long id) {
		this.id = id;
		return this;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public EnderecoDTO cep(String cep) {
		this.cep = cep;
		return this;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public EnderecoDTO logradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public EnderecoDTO numero(Integer numero) {
		this.numero = numero;
		return this;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public EnderecoDTO bairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public EnderecoDTO cidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public EnderecoDTO estado(String estado) {
		this.estado = estado;
		return this;
	}
    
}
