package com.tecnico.desafio.repository;

import com.tecnico.desafio.dto.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    private List<TransacaoDTO> transacaoDTOList = new ArrayList<>();

    public TransacaoDTO salvar(TransacaoDTO transacaoDTO) {
        this.transacaoDTOList.add(transacaoDTO);
        return transacaoDTO;
    }
}
