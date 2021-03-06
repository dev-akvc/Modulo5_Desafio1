package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Tipo;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Tipo tipo;
    private LocalDate dataDeVencimento;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDePagamento;
    private Status status;

}
