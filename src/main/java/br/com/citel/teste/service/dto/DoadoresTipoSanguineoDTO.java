package br.com.citel.teste.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.citel.teste.model.enums.TipoSanguineo;

public class DoadoresTipoSanguineoDTO {
    
	@JsonInclude(Include.NON_NULL)
    private TipoSanguineo tipoSanguineo;
    
    private String sangue;
    
    private Integer quantidade;

	public DoadoresTipoSanguineoDTO(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
		quantidade = 0;
		
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
				this.sangue = null;
		}
	}

	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getSangue() {
		return sangue;
	}

	public void setSangue(String sangue) {
		this.sangue = sangue;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void incrementQuantity() {
		this.quantidade++;
	}
}
