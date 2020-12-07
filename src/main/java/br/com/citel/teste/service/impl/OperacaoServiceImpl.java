package br.com.citel.teste.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.citel.teste.model.Pessoa;
import br.com.citel.teste.model.enums.TipoSanguineo;
import br.com.citel.teste.repository.PessoaRepository;
import br.com.citel.teste.service.OperacaoService;
import br.com.citel.teste.service.dto.CandidatosEstadoDTO;
import br.com.citel.teste.service.dto.DoadoresTipoSanguineoDTO;
import br.com.citel.teste.service.dto.MediaIdadeImcDTO;
import br.com.citel.teste.service.dto.MediaIdadeTipoSanguineoDTO;

@Service
@Transactional
public class OperacaoServiceImpl implements OperacaoService {

    private final PessoaRepository pessoaRepository;

    public OperacaoServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

	@Override
	public List<CandidatosEstadoDTO> getCandidatesByState() {
		return pessoaRepository.getCandidatesByState();
	}

	@Override
	public List<MediaIdadeImcDTO> getAverageByAge() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		List<MediaIdadeImcDTO> resultados = new ArrayList<>();

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getPeso() != null && pessoa.getAltura() != null) {
				separateByAgeRange(pessoa.calculateAge(), pessoa.calculateImc(), resultados);
			}
		}
		
		for(MediaIdadeImcDTO resultado : resultados) {
			resultado.calculateMedia();
		}

		return resultados;
	}
	
	private void separateByAgeRange(Integer idade, BigDecimal imc, List<MediaIdadeImcDTO> resultados) {
		for (int i = 10; i <= 100; i += 10) {
			if (idade > (i - 10) && idade <= i) {
				addOrUpdateAgeRange(imc, resultados, i);
			}
		}
	}
	
	private void addOrUpdateAgeRange(BigDecimal imc, List<MediaIdadeImcDTO> resultados, int index) {
		MediaIdadeImcDTO atual = null;
		for (MediaIdadeImcDTO resultado : resultados) {
			if (index == resultado.getFaixa()) {
				atual = resultado;
				resultado.addImc(imc);
				resultado.incrementQuantity();
				break;
			}
		}

		if (atual == null) {
			resultados.add(new MediaIdadeImcDTO(index, imc));
		}
	}

	@Override
	public List<MediaIdadeTipoSanguineoDTO> getAverageByBloodType() {
		
		List<MediaIdadeTipoSanguineoDTO> resultados = new ArrayList<>();
		
		List<Pessoa> pessoas = pessoaRepository.findAll();

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getTipoSanguineo() != null) {
				MediaIdadeTipoSanguineoDTO atual = null;
				for(MediaIdadeTipoSanguineoDTO resultado : resultados) {
					if(pessoa.getTipoSanguineo().equals(resultado.getTipoSanguineo())) {
						atual = resultado;
						resultado.addAge(pessoa.calculateAge());
						resultado.incrementQuantity();
						break;
					}
				}
				
				if(atual == null) {
					resultados.add(new MediaIdadeTipoSanguineoDTO(pessoa.getTipoSanguineo(), pessoa.calculateAge()));
				}
			}
		}
		
		for(MediaIdadeTipoSanguineoDTO resultado : resultados) {
			resultado.calculateAverage();
		}
		
		return resultados;
	}

	@Override
	public List<DoadoresTipoSanguineoDTO> getDonorsByBloodType() {

		List<Pessoa> pessoas = pessoaRepository.findAll();

		if(!pessoas.isEmpty()) {
			
			List<DoadoresTipoSanguineoDTO> resultados = createBloodTypeList();
			
			for(Pessoa pessoa : pessoas) {
				if(pessoa.getTipoSanguineo() != null 
						&& pessoa.calculateAge() >= 16 && pessoa.calculateAge() <= 69 
						&& (pessoa.getPeso().compareTo(new BigDecimal(50)) > 0)) {

					if(pessoa.getTipoSanguineo().equals(TipoSanguineo.A_POSITIVE)) {
						combativeWithTypeAPositive(resultados);
					}else if(pessoa.getTipoSanguineo().equals(TipoSanguineo.A_NEGATIVE)) {
						combativeWithTypeANegative(resultados);
					}else if(pessoa.getTipoSanguineo().equals(TipoSanguineo.B_POSITIVE)) {
						combativeWithTypeBPositive(resultados);
					}else if(pessoa.getTipoSanguineo().equals(TipoSanguineo.B_NEGATIVE)) {
						combativeWithTypeBNegative(resultados);
					}else if(pessoa.getTipoSanguineo().equals(TipoSanguineo.AB_POSITIVE)) {
						combativeWithTypeABPositive(resultados);
					}else if(pessoa.getTipoSanguineo().equals(TipoSanguineo.AB_NEGATIVE)) {
						combativeWithTypeABNegative(resultados);
					}else if(pessoa.getTipoSanguineo().equals(TipoSanguineo.O_POSITIVE) ) {
						combativeWithTypeOPositive(resultados);
					}else {
						combativeWithTypeONegative(resultados);
					}
				
				}
			}
			
			for(DoadoresTipoSanguineoDTO resultado : resultados) {
				resultado.setTipoSanguineo(null);
			}
			
			return resultados;
			
		}else {
			return new ArrayList<>();
		}
	}

	private void combativeWithTypeONegative(List<DoadoresTipoSanguineoDTO> resultados) {
		for(DoadoresTipoSanguineoDTO resultado : resultados) {
			resultado.incrementQuantity();
		}
	}

	private void combativeWithTypeOPositive(List<DoadoresTipoSanguineoDTO> resultados) {
		for(DoadoresTipoSanguineoDTO resultado : resultados) {
			if(resultado.getTipoSanguineo().equals(TipoSanguineo.A_POSITIVE) 
					|| resultado.getTipoSanguineo().equals(TipoSanguineo.B_POSITIVE) 
					|| resultado.getTipoSanguineo().equals(TipoSanguineo.O_POSITIVE) 
					|| resultado.getTipoSanguineo().equals(TipoSanguineo.AB_POSITIVE)) {
				resultado.incrementQuantity();
			}
		}
	}

	private void combativeWithTypeABNegative(List<DoadoresTipoSanguineoDTO> resultados) {
		for(DoadoresTipoSanguineoDTO resultado : resultados) {
			if(resultado.getTipoSanguineo().equals(TipoSanguineo.AB_POSITIVE) || resultado.getTipoSanguineo().equals(TipoSanguineo.AB_NEGATIVE)) {
				resultado.incrementQuantity();
			}
		}
	}

	private void combativeWithTypeABPositive(List<DoadoresTipoSanguineoDTO> resultados) {
		for(DoadoresTipoSanguineoDTO resultado : resultados) {
			if(resultado.getTipoSanguineo().equals(TipoSanguineo.AB_POSITIVE)) {
				resultado.incrementQuantity();
			}
		}
	}

	private void combativeWithTypeBNegative(List<DoadoresTipoSanguineoDTO> resultados) {
		for(DoadoresTipoSanguineoDTO resultado : resultados) {
			if(resultado.getTipoSanguineo().equals(TipoSanguineo.B_POSITIVE) 
					|| resultado.getTipoSanguineo().equals(TipoSanguineo.B_NEGATIVE) 
					|| resultado.getTipoSanguineo().equals(TipoSanguineo.AB_POSITIVE) 
					|| resultado.getTipoSanguineo().equals(TipoSanguineo.AB_NEGATIVE)) {
				resultado.incrementQuantity();
			}
		}
	}

	private void combativeWithTypeBPositive(List<DoadoresTipoSanguineoDTO> resultados) {
		for(DoadoresTipoSanguineoDTO resultado : resultados) {
			if(resultado.getTipoSanguineo().equals(TipoSanguineo.B_POSITIVE) || resultado.getTipoSanguineo().equals(TipoSanguineo.AB_POSITIVE)) {
				resultado.incrementQuantity();
			}
		}
	}

	private void combativeWithTypeANegative(List<DoadoresTipoSanguineoDTO> resultados) {
		for(DoadoresTipoSanguineoDTO resultado : resultados) {
			if(resultado.getTipoSanguineo().equals(TipoSanguineo.A_POSITIVE) 
					|| resultado.getTipoSanguineo().equals(TipoSanguineo.A_NEGATIVE) 
					|| resultado.getTipoSanguineo().equals(TipoSanguineo.AB_POSITIVE) 
					|| resultado.getTipoSanguineo().equals(TipoSanguineo.AB_NEGATIVE)) {
				resultado.incrementQuantity();
			}
		}
	}

	private void combativeWithTypeAPositive(List<DoadoresTipoSanguineoDTO> resultados) {
		for(DoadoresTipoSanguineoDTO resultado : resultados) {
			if(resultado.getTipoSanguineo().equals(TipoSanguineo.AB_POSITIVE) || resultado.getTipoSanguineo().equals(TipoSanguineo.A_POSITIVE)) {
				resultado.incrementQuantity();
			}
		}
	}

	private List<DoadoresTipoSanguineoDTO> createBloodTypeList() {
		
		List<DoadoresTipoSanguineoDTO> list = new ArrayList<>();
		
		list.add(new DoadoresTipoSanguineoDTO(TipoSanguineo.A_POSITIVE));
		list.add(new DoadoresTipoSanguineoDTO(TipoSanguineo.A_NEGATIVE));
		list.add(new DoadoresTipoSanguineoDTO(TipoSanguineo.B_POSITIVE));
		list.add(new DoadoresTipoSanguineoDTO(TipoSanguineo.B_NEGATIVE));
		list.add(new DoadoresTipoSanguineoDTO(TipoSanguineo.AB_POSITIVE));
		list.add(new DoadoresTipoSanguineoDTO(TipoSanguineo.AB_NEGATIVE));
		list.add(new DoadoresTipoSanguineoDTO(TipoSanguineo.O_POSITIVE));
		list.add(new DoadoresTipoSanguineoDTO(TipoSanguineo.O_NEGATIVE));
		
		return list;
	}


}
