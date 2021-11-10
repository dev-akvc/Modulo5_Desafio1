package br.com.zup.gerenciadordecontas.Gerenciador_de_contas.dtos;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.TipoConta;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RespostaCadastroDTO {
    private int id;
    private String nome;
    private double valor;
    private TipoConta tipo;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;

    public RespostaCadastroDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public LocalDateTime getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(LocalDateTime dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

}
