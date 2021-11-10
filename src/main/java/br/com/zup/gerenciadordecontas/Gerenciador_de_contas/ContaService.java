package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.StatusConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    LocalDate dataDeVencimento;

    public void cadastrarConta(Conta conta) {
        conta.setDataDePagamento(LocalDateTime.now());
        conta.setDataDeVencimento(LocalDate.of(dataDeVencimento.getDayOfMonth(), dataDeVencimento.getMonth(), dataDeVencimento.getYear()));
        if(dataDeVencimento.isBefore(LocalDate.now())){
            conta.setStatus(StatusConta.VENCIDA);
        } else{
            conta.setStatus(StatusConta.AGUARDANDO);
        }

        contaRepository.save(conta);
    }


}
