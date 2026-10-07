package br.projeto.agendamento.service;

import br.projeto.agendamento.dto.AgendamentoRequestDto;
import br.projeto.agendamento.entidades.Agendamento;
import br.projeto.agendamento.entidades.Transportadora;
import br.projeto.agendamento.repositorio.AgendamentoRepositorio;
import br.projeto.agendamento.repositorio.TransportadoraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepositorio agendamentoRepositorio;

    @Autowired
    private TransportadoraRepositorio transportadoraRepositorio;

    //LISTAR
    public List<Agendamento> listarTodos() { return agendamentoRepositorio.findAll(); }

    public Agendamento buscarPorId(Long id) {
        return agendamentoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento Não encontrado"));
    }

    // CRIAR (Create Crud)
    public Agendamento criar(AgendamentoRequestDto dto) {
        Agendamento novoAgendamento = new Agendamento();
        this.copiarDadosParaEntidade(dto, novoAgendamento);

        return agendamentoRepositorio.save(novoAgendamento);
    }

    //ATUALIZAR (Update crUd)
    public Agendamento atualizar(Long id, AgendamentoRequestDto dto) {
        Agendamento existente = this.buscarPorId(id);         // 1
        // this.normalizar(dto);                                 // 2
        //this.validarRegrasNegocio(dto, id);                   // 3
        this.copiarDadosParaEntidade(dto, existente);         // 4
        return agendamentoRepositorio.save(existente);        // 5
    }

    //DELETAR (delete crud)
    public void deletar(Long id) {
        if (!agendamentoRepositorio.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado!");
        }
        agendamentoRepositorio.deleteById(id);
    }

    // REGRAS DE NEGOCIO
    private void copiarDadosParaEntidade(AgendamentoRequestDto entrada, Agendamento saida) {
        if (entrada.getTipo() == null) {
            throw new RuntimeException("O campo Tipo é obrigatório (FORNECEDOR ou TRANSPORTADORA)");
        }

        Transportadora transportadora = transportadoraRepositorio.findById(entrada.getTransportadoraId())
                .orElseThrow(() -> new RuntimeException("Transportadora não encontrada"));

        saida.setTransportadora(transportadora);
        saida.setPlaca(entrada.getPlaca());
        saida.setTipoVeiculo(entrada.getTipoVeiculo());
        saida.setDataHora(entrada.getDataHora());
        saida.setPeso(entrada.getPeso());
        saida.setVolume(entrada.getVolume());
        saida.setPedido(entrada.getPedido());
        saida.setNotaFiscal(entrada.getNotaFiscal());
        saida.setObservacoes(entrada.getObservacoes());
        saida.setTipo((entrada.getTipo()));
    }
}