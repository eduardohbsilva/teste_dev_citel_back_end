package br.com.citel.teste.service.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class MediaIdadeImcDTO {
    
	@JsonInclude(Include.NON_NULL)
    private Integer faixa;
    
	@JsonInclude(Include.NON_NULL)
    private BigDecimal somaImc;
	
	@JsonInclude(Include.NON_NULL)
    private Integer quantidade;
	
	private String idade;
	
	private BigDecimal media;
	
	public MediaIdadeImcDTO() {
	}

	public MediaIdadeImcDTO(int faixa, BigDecimal imc) {
		this.faixa = faixa;
		this.somaImc = imc;
		this.quantidade = 1;
	}

	public Integer getFaixa() {
		return faixa;
	}

	public void setFaixa(Integer faixa) {
		this.faixa = faixa;
	}

	public BigDecimal getSomaImc() {
		return somaImc;
	}

	public void addImc(BigDecimal somaImc) {
		this.somaImc = this.somaImc.add(somaImc);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void incrementQuantity() {
		quantidade++;
	}

	public String getIdade() {
		return idade;
	}

	public BigDecimal getMedia() {
		return media;
	}
	
	public void calculateMedia() {
		this.media = somaImc.divide(new BigDecimal(quantidade), 2, RoundingMode.HALF_UP);
		idade = (faixa - 9) + " a " + faixa;
	    faixa = null;
	    somaImc = null;
	    quantidade = null;
	}
}
