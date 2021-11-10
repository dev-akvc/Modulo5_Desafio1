package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.StatusConta;
import lombok.Data;

@Data
public class ContaPagaDTO {
    private StatusConta status;
}
