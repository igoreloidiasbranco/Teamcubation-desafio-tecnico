package com.tecnico.desafio.service;

import com.tecnico.desafio.dto.TransacaoDTO;
import com.tecnico.desafio.repository.TransacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public ResponseEntity salvar(TransacaoDTO transacaoDTO) {
        return ResponseEntity.ok(transacaoRepository.salvar(transacaoDTO));
    }
}
