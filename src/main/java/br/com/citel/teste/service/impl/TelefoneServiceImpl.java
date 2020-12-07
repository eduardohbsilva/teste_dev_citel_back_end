package br.com.citel.teste.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.citel.teste.model.Telefone;
import br.com.citel.teste.service.TelefoneService;
import br.com.citel.teste.service.dto.TelefoneDTO;

@Service
@Transactional
public class TelefoneServiceImpl implements TelefoneService {

	@Override
	public TelefoneDTO toDto(Telefone telefone) {
		return new TelefoneDTO().id(telefone.getId()).numero(telefone.getNumero()).tipo(telefone.getTipo());
	}

	@Override
	public Telefone toEntity(TelefoneDTO telefoneDTO) {
		return new Telefone().id(telefoneDTO.getId()).numero(telefoneDTO.getNumero()).tipo(telefoneDTO.getTipo());
	}

}
