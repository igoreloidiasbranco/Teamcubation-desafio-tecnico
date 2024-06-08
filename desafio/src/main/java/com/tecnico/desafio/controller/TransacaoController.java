package com.tecnico.desafio.controller;

import com.tecnico.desafio.dto.TransacaoDTO;
import com.tecnico.desafio.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
