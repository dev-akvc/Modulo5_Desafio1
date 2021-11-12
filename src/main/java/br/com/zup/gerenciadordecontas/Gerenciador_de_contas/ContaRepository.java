package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Tipo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContaRepository extends CrudRepository<Conta, Integer> {
    List<Conta> findAllByStatus(Status status);

    List<Conta> findAllByTipo(Tipo tipo);

    @Query(value = "SELECT * FROM contas WHERE valor BETWEEN :valor*0.85 AND :valor*1.15", nativeQuery = true)
    List<Conta> findAllByValorAproximado(double valor);
}
