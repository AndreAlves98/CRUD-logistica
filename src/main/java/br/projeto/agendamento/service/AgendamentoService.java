package br.projeto.agendamento.service;


import br.projeto.agendamento.dto.AgendamentoRequestDto;
import br.projeto.agendamento.entidades.Agendamento;
import br.projeto.agendamento.repositorio.AgendamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepositorio agendamentoRepositorio;

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
            throw new RuntimeException ("Agendamento não encontrado!");
        }
        agendamentoRepositorio.deleteById(id);
    }


    // REGRAS DE NEGOCIO
    private void copiarDadosParaEntidade(AgendamentoRequestDto entrada, Agendamento saida) {
        saida.setCnpj(entrada.getCnpj());
        saida.setTransportadora(entrada.getTransportadora());
        saida.setTelefone(entrada.getTelefone());
        saida.setEmail(entrada.getEmail());
        saida.setPlaca(entrada.getPlaca());
        saida.setTipoVeiculo(entrada.getTipoVeiculo());
        saida.setDataHora(entrada.getDataHora());
        saida.setPeso(entrada.getPeso());
        saida.setVolume(entrada.getVolume());
        saida.setPedido(entrada.getPedido());
    }



}
