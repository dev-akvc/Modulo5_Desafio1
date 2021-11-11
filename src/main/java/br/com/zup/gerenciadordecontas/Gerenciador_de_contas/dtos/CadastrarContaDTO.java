package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.TipoConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class CadastrarContaDTO {
    @NotBlank(message = "Nome da conta deve ser preenchido")
    private String nome;
    @NotBlank(message = "Valor da conta deve ser preenchido")
    private double valor;
    @NotBlank(message = "Tipo da conta deve ser preenchido")
    private TipoConta tipo;
    private LocalDate dataDeVencimento;

}
