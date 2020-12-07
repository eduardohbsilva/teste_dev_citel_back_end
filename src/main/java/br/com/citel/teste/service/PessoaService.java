package br.com.citel.teste.service;

import java.util.List;

import br.com.citel.teste.service.dto.AuxiliarDTO;
import br.com.citel.teste.service.dto.PessoaDTO;

public interface PessoaService {

	List<PessoaDTO> createPessoas(AuxiliarDTO objetoDTO);
	
}
