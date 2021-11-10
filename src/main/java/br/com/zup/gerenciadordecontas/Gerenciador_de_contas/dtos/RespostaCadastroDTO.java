package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.TipoConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class RespostaCadastroDTO {
    private int id;
    private String nome;
    private double valor;
    private TipoConta tipo;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;

}
