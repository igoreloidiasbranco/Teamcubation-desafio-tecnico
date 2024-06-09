package com.tecnico.desafio.service;

import com.tecnico.desafio.dto.TransacaoDTO;
import com.tecnico.desafio.repository.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public ResponseEntity salvar(TransacaoDTO transacaoDTO) {

        OffsetDateTime currentDateTime = OffsetDateTime.now();
        if (transacaoDTO.getDataHora().isAfter(currentDateTime) || transacaoDTO.getValor() < 0) {
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        transacaoRepository.salvar(transacaoDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public void deletar() {
        transacaoRepository.deletar();
    }
}
