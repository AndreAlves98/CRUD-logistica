package br.projeto.agendamento.entidades;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 14)
    private String cnpj;

    @Column(nullable = false, length = 50)
    private String transportadora;

    @Column(nullable = false, length = 11)
    private String telefone;

    @Column(nullable = false, length = 200)
    private String email;

    @Column(nullable = false, length = 10)
    private String placa;

    @Column(nullable = false, length = 30)
    private String tipoVeiculo;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private double peso;

    @Column(nullable = false)
    private int volume;

    @Column(length = 6)
    private int pedido;

    public Agendamento() {}

    public Agendamento(Long id, String cnpj, String transportadora, String telefone, String email,
                       String placa, String tipoVeiculo, LocalDateTime dataHora, double peso, int volume, int pedido) {

        this.id = id;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }
}
