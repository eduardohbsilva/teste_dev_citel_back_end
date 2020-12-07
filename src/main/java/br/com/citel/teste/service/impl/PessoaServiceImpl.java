package br.com.citel.teste.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.citel.teste.model.Endereco;
import br.com.citel.teste.model.Pessoa;
import br.com.citel.teste.model.Telefone;
import br.com.citel.teste.model.enums.TipoPessoa;
import br.com.citel.teste.model.enums.TipoSexo;
import br.com.citel.teste.repository.PessoaRepository;
import br.com.citel.teste.service.EnderecoService;
import br.com.citel.teste.service.PessoaService;
import br.com.citel.teste.service.TelefoneService;
import br.com.citel.teste.service.dto.AuxiliarDTO;
import br.com.citel.teste.service.dto.EnderecoDTO;
import br.com.citel.teste.service.dto.PessoaDTO;
import br.com.citel.teste.service.dto.TelefoneDTO;

@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {

	private final PessoaRepository pessoaRepository;

	private final EnderecoService enderecoService;

	private final TelefoneService telefoneService;

	public PessoaServiceImpl(PessoaRepository pessoaRepository, EnderecoService enderecoService,
			TelefoneService telefoneService) {
		this.pessoaRepository = pessoaRepository;
		this.enderecoService = enderecoService;
		this.telefoneService = telefoneService;
	}

	@Override
	public List<PessoaDTO> createPessoas(AuxiliarDTO objetoDTO) {

		List<PessoaDTO> pessoas = new ArrayList<>();

		for (PessoaDTO pessoaDTO : objetoDTO.getPessoas()) {
			
			pessoaDTO.addEndereco(new EnderecoDTO().cep(pessoaDTO.getCep()).logradouro(pessoaDTO.getEndereco())
					.numero(pessoaDTO.getNumero()).bairro(pessoaDTO.getBairro()).cidade(pessoaDTO.getCidade())
					.estado(pessoaDTO.getEstado()));
			
			Pessoa pessoa = toEntity(pessoaDTO).tipoPessoa(TipoPessoa.FILHO);
			pessoa.getPessoas().add(new Pessoa().nome(pessoaDTO.getMae()).tipoPessoa(TipoPessoa.MAE).sexo(TipoSexo.FEMININO));
			pessoa.getPessoas().add(new Pessoa().nome(pessoaDTO.getPai()).tipoPessoa(TipoPessoa.PAI).sexo(TipoSexo.MASCULINO));
			pessoas.add(toDto(pessoaRepository.save(pessoa)));
		}

		return pessoas;
	}

	private PessoaDTO toDto(Pessoa pessoa) {

		PessoaDTO dto = new PessoaDTO().id(pessoa.getId()).nome(pessoa.getNome()).cpf(pessoa.getCpf())
				.rg(pessoa.getRg()).dataNasc(pessoa.getDataNasc()).sexo(pessoa.getSexo()).email(pessoa.getEmail())
				.altura(pessoa.getAltura()).peso(pessoa.getPeso()).tipoSanguineo(pessoa.getTipoSanguineo())
				.tipoPessoa(pessoa.getTipoPessoa());

		for (Endereco endereco : pessoa.getEnderecos()) {
			dto.addEndereco(enderecoService.toDto(endereco));
		}

		for (Telefone telefone : pessoa.getTelefones()) {
			dto.addTelefone(telefoneService.toDto(telefone));
		}

		for (Pessoa pessoaVinculada : pessoa.getPessoas()) {
			dto.addPessoa(toDto(pessoaVinculada));
		}

		return dto;
	}

	private Pessoa toEntity(PessoaDTO pessoaDTO) {

		Pessoa entity = new Pessoa().id(pessoaDTO.getId()).nome(pessoaDTO.getNome()).cpf(pessoaDTO.getCpf())
				.rg(pessoaDTO.getRg()).dataNasc(pessoaDTO.getDataNasc()).sexo(pessoaDTO.getSexo())
				.email(pessoaDTO.getEmail()).altura(pessoaDTO.getAltura()).peso(pessoaDTO.getPeso())
				.tipoSanguineo(pessoaDTO.getTipoSanguineo());

		for (EnderecoDTO endereco : pessoaDTO.getEnderecos()) {
			entity.addEndereco(enderecoService.toEntity(endereco));
		}

		for (TelefoneDTO telefone : pessoaDTO.getTelefones()) {
			entity.addTelefone(telefoneService.toEntity(telefone));
		}

		for (PessoaDTO pessoaVinculada : pessoaDTO.getPessoas()) {
			entity.addPessoa(toEntity(pessoaVinculada));
		}

		return entity;
	}
}
