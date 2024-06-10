package com.tecnico.desafio.dto;

import java.time.OffsetDateTime;

public class TransacaoDTO {

    private Double valor;
    OffsetDateTime dataHora;


    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
