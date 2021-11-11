package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErroDeValidacao {
    private String campo;
    private String mensagem;
}
