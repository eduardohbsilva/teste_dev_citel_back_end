package br.com.citel.teste.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.citel.teste.model.enums.TipoSanguineo;

public class MediaIdadeTipoSanguineoDTO {
    
	@JsonInclude(Include.NON_NULL)
    private TipoSanguineo tipoSanguineo;
    
    @JsonInclude(Include.NON_NULL)
    private Integer somaIdade;
    
    @JsonInclude(Include.NON_NULL)
    private Integer quantidade;
    
    private String sangue;
    
    private Integer media;
    
	public MediaIdadeTipoSanguineoDTO() {
	}

	public MediaIdadeTipoSanguineoDTO(TipoSanguineo tipoSanguineo, Integer somaIdade) {
		this.tipoSanguineo = tipoSanguineo;
		this.somaIdade = somaIdade;
		this.quantidade = 1;
	}

	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public Integer getSomaIdade() {
		return somaIdade;
	}

	public Integer getMedia() {
		return media;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public String getSangue() {
		return sangue;
	}

	public void addAge(Integer idade) {
		somaIdade += idade;
	}
	
	public void calculateAverage() {
		media = somaIdade / quantidade;
		
		switch (tipoSanguineo) {
		case A_POSITIVE:
			this.sangue = "A+";
			break;
		case A_NEGATIVE:
			this.sangue = "A-";
			break;
		case B_POSITIVE:
			this.sangue = "B+";
			break;
		case B_NEGATIVE:
			this.sangue = "B-";
			break;
		case AB_POSITIVE:
			this.sangue = "AB+";
			break;
		case AB_NEGATIVE:
			this.sangue = "AB-";
			break;
		case O_POSITIVE:
			this.sangue = "O+";
			break;
		case O_NEGATIVE:
			this.sangue = "O-";
			break;

		default:
			this.tipoSanguineo = null;
		}
		
		somaIdade = null;
		quantidade = null;
		tipoSanguineo = null;
	}
	
	public void incrementQuantity() {
		quantidade++;
	}
}
