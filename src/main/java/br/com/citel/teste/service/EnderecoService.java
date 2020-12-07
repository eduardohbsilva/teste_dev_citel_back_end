package br.com.citel.teste.service;

import br.com.citel.teste.model.Endereco;
import br.com.citel.teste.service.dto.EnderecoDTO;

public interface EnderecoService {

	EnderecoDTO toDto(Endereco endereco);

	Endereco toEntity(EnderecoDTO enderecoDTO);
	
}
