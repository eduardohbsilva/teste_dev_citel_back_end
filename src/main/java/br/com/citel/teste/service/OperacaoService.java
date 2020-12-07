package br.com.citel.teste.service;

import java.util.List;

import br.com.citel.teste.service.dto.CandidatosEstadoDTO;
import br.com.citel.teste.service.dto.DoadoresTipoSanguineoDTO;
import br.com.citel.teste.service.dto.MediaIdadeImcDTO;
import br.com.citel.teste.service.dto.MediaIdadeTipoSanguineoDTO;

public interface OperacaoService {

	List<CandidatosEstadoDTO> getCandidatesByState();

	List<MediaIdadeImcDTO> getAverageByAge();

	List<MediaIdadeTipoSanguineoDTO> getAverageByBloodType();

	List<DoadoresTipoSanguineoDTO> getDonorsByBloodType();
	
}
