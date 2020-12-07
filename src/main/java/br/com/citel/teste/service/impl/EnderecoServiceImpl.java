package br.com.citel.teste.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.citel.teste.model.Endereco;
import br.com.citel.teste.service.EnderecoService;
import br.com.citel.teste.service.dto.EnderecoDTO;

@Service
@Transactional
public class EnderecoServiceImpl implements EnderecoService {

	@Override
	public EnderecoDTO toDto(Endereco endereco) {
		return new EnderecoDTO().id(endereco.getId()).cep(endereco.getCep()).logradouro(endereco.getLogradouro())
				.numero(endereco.getNumero()).bairro(endereco.getBairro()).cidade(endereco.getCidade())
				.estado(endereco.getEstado());
	}

	@Override
	public Endereco toEntity(EnderecoDTO enderecoDTO) {
		return new Endereco().id(enderecoDTO.getId()).cep(enderecoDTO.getCep()).logradouro(enderecoDTO.getLogradouro())
				.numero(enderecoDTO.getNumero()).bairro(enderecoDTO.getBairro()).cidade(enderecoDTO.getCidade())
				.estado(enderecoDTO.getEstado());
	}

}
