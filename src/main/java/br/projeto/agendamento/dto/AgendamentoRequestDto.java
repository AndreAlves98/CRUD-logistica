package br.projeto.agendamento.dto;


import java.time.LocalDateTime;

public class AgendamentoRequestDto {

    private String cnpj;
    private String transportadora;
    private String telefone;
    private String email;
    private String placa;
    private String tipoVeiculo;
    private LocalDateTime dataHora;
    private double peso;
    private int volume;
    private String pedido;


    public AgendamentoRequestDto() {}

    public AgendamentoRequestDto(String cnpj, String transportadora, String telefone, String email,
                                 String placa, String tipoVeiculo, LocalDateTime dataHora, double peso, int volume, String pedido) {
        this.cnpj = cnpj;
        this.transportadora = transportadora;
        this.telefone = telefone;
        this.email = email;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        this.dataHora = dataHora;
        this.peso = peso;
        this.volume = volume;
        this.pedido = pedido;
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
}
