package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Status;
import lombok.Data;

@Data
public class ResumoContaDTO {
    private int id;
    private String nome;
    private double valor;
    private Status status;

}
