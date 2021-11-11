package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class CadastrarContaDTO {
    @Size(min=5, max = 20, message = "Nome deve ter entre 5 e 20 caracteres")
    private String nome;
    @Min(value = 1, message = "Valor mínimo da conta é R$1,00")
    private double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;

}
