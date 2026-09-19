package br.projeto.agendamento.repositorio;


import br.projeto.agendamento.entidades.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepositorio extends JpaRepository<Agendamento, Long> {
}
