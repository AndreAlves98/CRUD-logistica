package br.projeto.agendamento.service;

import br.projeto.agendamento.dto.TransportadoraRequestDto;
import br.projeto.agendamento.entidades.Transportadora;
import br.projeto.agendamento.repositorio.TransportadoraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportadoraService {

    @Autowired
    private TransportadoraRepositorio transportadoraRepositorio;

    //LISTAR
    public List<Transportadora> listarTodos() {
        return transportadoraRepositorio.findAll();
    }

    public Transportadora buscarPorId(Long id) {
        return transportadoraRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Transportadora não encontrada"));
    }

    // CRIAR (Create Crud)
    public Transportadora criar(TransportadoraRequestDto dto) {
        if (transportadoraRepositorio.existsByCnpj(dto.getCnpj())) {
            throw new RuntimeException("Já existe uma transportadora com este CNPJ");
        }

        Transportadora nova = new Transportadora();
        this.copiarDadosParaEntidade(dto, nova);

        return transportadoraRepositorio.save(nova);
    }

    //ATUALIZAR (Update crUd)
    public Transportadora atualizar(Long id, TransportadoraRequestDto dto) {
        Transportadora existente = this.buscarPorId(id);

        if (transportadoraRepositorio.existsByCnpjAndIdNot(dto.getCnpj(), id)) {
            throw new RuntimeException("Já existe uma transportadora com este CNPJ");
        }

        this.copiarDadosParaEntidade(dto, existente);
        return transportadoraRepositorio.save(existente);
    }

    //DELETAR (delete crud)
    public void deletar(Long id) {
        if (!transportadoraRepositorio.existsById(id)) {
            throw new RuntimeException("Transportadora não encontrada!");
        }
        transportadoraRepositorio.deleteById(id);
    }

    // REGRAS DE NEGOCIO
    private void copiarDadosParaEntidade(TransportadoraRequestDto entrada, Transportadora saida) {
        saida.setCnpj(entrada.getCnpj());
        saida.setNome(entrada.getNome());
        saida.setTelefone(entrada.getTelefone());
        saida.setEmail(entrada.getEmail());
    }
}
