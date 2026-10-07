package br.projeto.agendamento.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transportadora_id", nullable = false)
    private Transportadora transportadora;



    @Column(nullable = false, length = 10)
    private String placa;

    @Column(nullable = false, length = 30)
    private String tipoVeiculo;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false, length = 5)
    private double peso;

    @Column(nullable = false, length = 4)
    private int volume;

    @Column(length = 6)
    private String pedido;

    @Column(length = 9)
    private String notaFiscal;

    @Column(length = 500)
    private String observacoes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoAgendamento tipo;

    public Agendamento() {}

    public Agendamento(Long id, Transportadora transportadora, String placa, String tipoVeiculo,
                       LocalDateTime dataHora, double peso, int volume, String pedido,
                       String notaFiscal, String observacoes, TipoAgendamento tipo) {
        this.id = id;
        this.transportadora = transportadora;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        this.dataHora = dataHora;
        this.peso = peso;
        this.volume = volume;
        this.pedido = pedido;
        this.notaFiscal = notaFiscal;
        this.observacoes = observacoes;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
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

    public TipoAgendamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAgendamento tipo) {
        this.tipo = tipo;
    }
}