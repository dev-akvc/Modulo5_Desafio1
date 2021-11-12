package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.exceptions;

public class StatusInvalidoException extends RuntimeException {
    public StatusInvalidoException (String message) {
        super(message);
    }

}
