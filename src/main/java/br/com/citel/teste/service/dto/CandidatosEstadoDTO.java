package br.com.citel.teste.service.dto;

public class CandidatosEstadoDTO {
    
    private Integer quantidade;
    
    private String estado;
    
    public CandidatosEstadoDTO() {
	}

	public CandidatosEstadoDTO(Long quantidade, String estado) {
		this.quantidade = quantidade.intValue();
		this.estado = estado;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
