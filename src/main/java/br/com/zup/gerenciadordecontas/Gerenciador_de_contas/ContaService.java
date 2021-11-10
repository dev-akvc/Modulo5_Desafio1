package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    LocalDate dataDeVencimento;

    public void cadastrarConta(Conta conta) {
        conta.setDataDeVencimento(LocalDate.of(dataDeVencimento.getDayOfMonth(), dataDeVencimento.getMonth(), dataDeVencimento.getYear()));
        contaRepository.save(conta);
    }


}
