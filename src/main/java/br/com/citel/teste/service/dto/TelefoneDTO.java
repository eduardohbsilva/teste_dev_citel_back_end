package br.com.citel.teste.service.dto;

import br.com.citel.teste.model.enums.TipoTelefone;

public class TelefoneDTO {
    
    private Long id;

    private String numero;

    private TipoTelefone tipo;
    
	public TelefoneDTO() {
	}

	public TelefoneDTO(String numero, TipoTelefone tipo) {
		this.numero = numero;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public TelefoneDTO id(Long id) {
		this.id = id;
		return this;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public TelefoneDTO numero(String numero) {
		this.numero = numero;
		return this;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}
	
	public TelefoneDTO tipo(TipoTelefone tipo) {
		this.tipo = tipo;
		return this;
	}
}
