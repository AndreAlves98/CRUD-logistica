package br.projeto.agendamento.repositorio;

import br.projeto.agendamento.entidades.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportadoraRepositorio extends JpaRepository<Transportadora, Long> {

    //verifica se existe registro que a coluna cnpj seja igual à String passada.
    boolean existsByCnpj(String cnpj);

    //Verifica se existe um registro com o CNPJ informado, mas que tenha um ID diferente (IdNot)
    // do ID que foi passado no segundo parâmetro.
    boolean existsByCnpjAndIdNot(String cnpj, Long id);
}