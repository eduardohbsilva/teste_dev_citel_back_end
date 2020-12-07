package br.com.citel.teste.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.citel.teste.service.PessoaService;
import br.com.citel.teste.service.dto.AuxiliarDTO;
import br.com.citel.teste.service.dto.PessoaDTO;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/pessoas")
    public ResponseEntity<List<PessoaDTO>> createPessoas(@RequestBody AuxiliarDTO objetoDTO) {
        List<PessoaDTO> result = pessoaService.createPessoas(objetoDTO);
        return ResponseEntity.ok().body(result);
    }

}
