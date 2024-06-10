package com.tecnico.desafio.controller;

import com.tecnico.desafio.dto.EstatisticaDTO;
import com.tecnico.desafio.dto.TransacaoDTO;
import com.tecnico.desafio.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TransacaoController {

    final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }


    @PostMapping("/transacao")
    public ResponseEntity salvar (@RequestBody TransacaoDTO transacaoDTO) {
        ResponseEntity responseEntity = transacaoService.salvar(transacaoDTO);
        return responseEntity;
    }

    @DeleteMapping("/transacao")
    public ResponseEntity deletar () {
        transacaoService.deletar();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticaDTO>  getEstatisticaDoUltimoMinuto() {
        return transacaoService.getEstatisticaDoUltimoMinuto();
    }

}
