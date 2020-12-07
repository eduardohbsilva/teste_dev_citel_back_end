package br.com.citel.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.citel.teste.model.Pessoa;
import br.com.citel.teste.service.dto.CandidatosEstadoDTO;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query("SELECT new br.com.citel.teste.service.dto.CandidatosEstadoDTO(COUNT(*), e.estado) "
			+ "FROM Pessoa p JOIN Endereco e ON e.pessoa.id = p.id "
			+ "WHERE p.cpf IS NOT NULL "
			+ "GROUP BY e.estado")
	List<CandidatosEstadoDTO> getCandidatesByState();
}
