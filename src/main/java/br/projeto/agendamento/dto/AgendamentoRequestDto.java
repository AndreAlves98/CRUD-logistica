package br.projeto.agendamento.dto;

import java.time.LocalDateTime;

public class AgendamentoRequestDto {

    private Long transportadoraId;
    private String placa;
    private String tipoVeiculo;
    private LocalDateTime dataHora;
    private double peso;
    private int volume;
    private int pedido;
    private String notaFiscal;
    private String observacoes;

    public AgendamentoRequestDto() {}

    public AgendamentoRequestDto(Long transportadoraId, String placa, String tipoVeiculo,
                                 LocalDateTime dataHora, double peso, int volume, int pedido,
                                 String notaFiscal, String observacoes) {
        this.transportadoraId = transportadoraId;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        this.dataHora = dataHora;
        this.peso = peso;
        this.volume = volume;
        this.pedido = pedido;
        this.notaFiscal = notaFiscal;
        this.observacoes = observacoes;
    }

    public Long getTransportadoraId() {
        return transportadoraId;
    }

    public void setTransportadoraId(Long transportadoraId) {
        this.transportadoraId = transportadoraId;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}