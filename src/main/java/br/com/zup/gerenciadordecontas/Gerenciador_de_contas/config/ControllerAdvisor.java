package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.config;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.exceptions.ContaNaoLocalizadaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ErroDeValidacao> manipularErrosDeValidacao(MethodArgumentNotValidException exception) {
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
    public MensagemDeErro manipularExcecaoDeContaNaoLocalizada(ContaNaoLocalizadaException exception) {
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularExcecaoDeEnumInvalido(HttpMessageNotReadableException exception) {
        if (exception.getLocalizedMessage().contains("br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.StatusConta")) {
            return new MensagemDeErro("Status não reconhecido");
        }
        else if (exception.getLocalizedMessage().contains("br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.TipoConta")) {
            return new MensagemDeErro("Tipo não reconhecido");
        }

        return new MensagemDeErro(exception.getLocalizedMessage());
    }

    @ExceptionHandler(DateTimeParseException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularExcecaoDeDataInvalida(DateTimeParseException exception) {
        return new MensagemDeErro("Data inválida");
    }

}
