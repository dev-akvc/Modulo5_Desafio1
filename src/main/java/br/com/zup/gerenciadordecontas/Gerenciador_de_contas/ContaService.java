package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Tipo;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.exceptions.ContaNaoLocalizadaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public Status atualizarStatusConta(Conta conta) {
        if (conta.getDataDeVencimento().isBefore(LocalDate.now())) {
            conta.setStatus(Status.VENCIDA);
        } else {
            conta.setStatus(Status.AGUARDANDO);
        }
        return conta.getStatus();

    }

    public List<Conta> buscarContasCadastradas(Status status, Tipo tipo) {
        if (status != null) {
            return contaRepository.findAllByStatus(status);
        }
        if (tipo != null) {
            return contaRepository.findAllByTipo(tipo);
        }
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
        conta.setStatus(Status.PAGO);
        conta.setDataDePagamento(LocalDateTime.now());
        contaRepository.save(conta);

        return conta;
    }

    public void deletarCarro(int id){
        if (contaRepository.existsById(id)) {
            contaRepository.deleteById(id);
        } else {
            throw new ContaNaoLocalizadaException("Conta não localizada!");
        }
    }

}

