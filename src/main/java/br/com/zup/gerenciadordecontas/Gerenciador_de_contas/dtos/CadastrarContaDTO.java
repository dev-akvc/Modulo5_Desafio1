package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Tipo;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class CadastrarContaDTO {
    @Size(min=5, max = 20, message = "Nome deve ter entre 5 e 20 caracteres")
    @NotNull
    @NotEmpty
    private String nome;
    @Min(value = 1, message = "Valor mínimo da conta é R$1,00")
    @NotNull
    private double valor;
    private Tipo tipo;
    @NotNull
    private LocalDate dataDeVencimento;

}
