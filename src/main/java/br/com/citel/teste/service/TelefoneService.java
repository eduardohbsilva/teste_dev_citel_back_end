package br.com.citel.teste.service;

import br.com.citel.teste.model.Telefone;
import br.com.citel.teste.service.dto.TelefoneDTO;

public interface TelefoneService {

	TelefoneDTO toDto(Telefone telefone);

	Telefone toEntity(TelefoneDTO telefoneDTO);
	
}
