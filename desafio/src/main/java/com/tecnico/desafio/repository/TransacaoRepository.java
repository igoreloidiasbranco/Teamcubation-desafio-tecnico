package com.tecnico.desafio.repository;

import com.tecnico.desafio.dto.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    private List<TransacaoDTO> transacaoDTOList = new ArrayList<>();

    public TransacaoDTO salvar(TransacaoDTO transacaoDTO) {
        this.transacaoDTOList.add(transacaoDTO);
        return transacaoDTO;
    }

    public void deletar() {
        this.transacaoDTOList.clear();
    }

    public List<TransacaoDTO> getTransacaoDTOListDoUltimoMinuto() {
        List<TransacaoDTO> transacaoDTOListDoUltimoMinuto = new ArrayList<>();
        OffsetDateTime agora = OffsetDateTime.now();
        OffsetDateTime ultimoMinuto = agora.minusMinutes(1);

        for (TransacaoDTO transacaoDTO : transacaoDTOList) {
            OffsetDateTime dataHora = transacaoDTO.getDataHora();
            if (dataHora.isAfter(ultimoMinuto) && dataHora.isBefore(agora)) {
                transacaoDTOListDoUltimoMinuto.add(transacaoDTO);
            }
        }
        return transacaoDTOListDoUltimoMinuto;
    }
}
