package br.com.citel.teste.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.citel.teste.service.OperacaoService;
import br.com.citel.teste.service.dto.CandidatosEstadoDTO;
import br.com.citel.teste.service.dto.DoadoresTipoSanguineoDTO;
import br.com.citel.teste.service.dto.MediaIdadeImcDTO;
import br.com.citel.teste.service.dto.MediaIdadeTipoSanguineoDTO;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OperacaoController {

    private final OperacaoService operacaoService;

    public OperacaoController(OperacaoService operacaoService) {
        this.operacaoService = operacaoService;
    }

    @GetMapping("/candidatos")
    public ResponseEntity<List<CandidatosEstadoDTO>> getCandidatesByState() {
        return ResponseEntity.ok().body(operacaoService.getCandidatesByState());
    }
    
    @GetMapping("/media-imc-idade")
    public ResponseEntity<List<MediaIdadeImcDTO>> getAverageByAge() {
        return ResponseEntity.ok().body(operacaoService.getAverageByAge());
    }
    
    @GetMapping("/media-obesos-generos")
    public void getAverageOfObeseByGender() {
    }
    
    @GetMapping("/media-tipo-sanguineo")
    public ResponseEntity<List<MediaIdadeTipoSanguineoDTO>> getAverageByBloodType() {
        return ResponseEntity.ok().body(operacaoService.getAverageByBloodType());
    }
    
    @GetMapping("/doadores-tipo-sanguineo")
    public ResponseEntity<List<DoadoresTipoSanguineoDTO>> getDonorsByBloodType() {
        return ResponseEntity.ok().body(operacaoService.getDonorsByBloodType());
    }
    
}
