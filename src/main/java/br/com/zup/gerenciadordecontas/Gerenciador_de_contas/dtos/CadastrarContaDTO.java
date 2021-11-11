package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.TipoConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class CadastrarContaDTO {
    @NotBlank(message = "Nome da conta deve ser preenchido")
    private String nome;
    @NotBlank(message = "Valor da conta deve ser preenchido")
    @Min(value = 1, message = "Valor mínimo da conta é R$1,00")
    private double valor;
    @NotBlank(message = "Tipo da conta deve ser preenchido")
    private TipoConta tipo;
    @NotBlank(message = "Data de vencimento da conta deve ser preenchida")
    private LocalDate dataDeVencimento;

}
