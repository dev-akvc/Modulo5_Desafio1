package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.StatusConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;


    public Conta cadastrarConta(Conta conta) {
        atualizarStatusConta(conta);
        conta.setDataDePagamento(null);
        return contaRepository.save(conta);

    }

    public StatusConta atualizarStatusConta(Conta conta) {
        if (conta.getDataDeVencimento().isBefore(LocalDate.now())) {
            conta.setStatus(StatusConta.VENCIDA);
        } else{
        conta.setStatus(StatusConta.AGUARDANDO);
        }
        return conta.getStatus();

    }

}
