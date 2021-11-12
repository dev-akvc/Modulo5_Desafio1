package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.config;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.exceptions.ContaNaoLocalizadaException;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.exceptions.StatusInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ErroDeValidacao> ErrosDeValidacao(MethodArgumentNotValidException exception) {
        List<ErroDeValidacao> erros = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            ErroDeValidacao erroDeValidacao = new ErroDeValidacao(fieldError.getField(),
                    fieldError.getDefaultMessage());
            erros.add(erroDeValidacao);
        }

        return erros;
    }

    @ExceptionHandler(ContaNaoLocalizadaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro ExcecaoDeContaNaoLocalizada(ContaNaoLocalizadaException exception) {
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(StatusInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro statusInvalidoException(StatusInvalidoException exception) {
        return new MensagemDeErro(exception.getLocalizedMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro ExcecaoDeEnumInvalido(HttpMessageNotReadableException exception) {
        return new MensagemDeErro("Tipo inválido!");
    }


}
