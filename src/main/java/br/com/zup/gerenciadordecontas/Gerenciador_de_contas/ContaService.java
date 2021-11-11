package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.StatusConta;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.exceptions.ContaNaoLocalizadaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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
        } else {
            conta.setStatus(StatusConta.AGUARDANDO);
        }
        return conta.getStatus();

    }

    public List<Conta> buscarContasCadastradas() {
        Iterable<Conta> listaContas = contaRepository.findAll();
        return (List<Conta>) listaContas;
    }

    public Conta localizarContaPorId(int id) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if (contaOptional.isPresent()) {
            return contaOptional.get();
        }

        throw new ContaNaoLocalizadaException("Conta não localizada!");
    }

    public Conta pagarConta(int id) {
        Conta conta = localizarContaPorId(id);
        conta.setStatus(StatusConta.PAGA);
        conta.setDataDePagamento(LocalDateTime.now());
        contaRepository.save(conta);

        return conta;
    }

}

