package com.tecnico.desafio.service;

import com.tecnico.desafio.dto.EstatisticaDTO;
import com.tecnico.desafio.dto.TransacaoDTO;
import com.tecnico.desafio.repository.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

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

    public ResponseEntity<EstatisticaDTO> getEstatisticaDoUltimoMinuto() {
        List<TransacaoDTO> transacaoDTOListDoUltimoMinuto = transacaoRepository.getTransacaoDTOListDoUltimoMinuto();
        EstatisticaDTO estatisticaDTO = new EstatisticaDTO();
        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();

        for (TransacaoDTO transacaoDTO : transacaoDTOListDoUltimoMinuto) {
            stats.accept(transacaoDTO.getValor());
        }

        estatisticaDTO.setCount(stats.getCount());
        estatisticaDTO.setSum(stats.getSum());
        estatisticaDTO.setAvg(stats.getAverage());
        estatisticaDTO.setMin(stats.getMin());
        estatisticaDTO.setMax(stats.getMax());

        return ResponseEntity.ok(estatisticaDTO);

    }
}
