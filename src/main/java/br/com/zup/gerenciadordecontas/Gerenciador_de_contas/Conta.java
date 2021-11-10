package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.StatusConta;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.TipoConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private double valor;
    @Enumerated(EnumType.STRING)
    private TipoConta tipo;
    @Enumerated(EnumType.STRING)
    private StatusConta status;
    @Column(name = "data_de_vencimento")
    private LocalDate dataDeVencimento;
    @Column(name = "data_de_pagamento", nullable = false)
    private LocalDateTime dataDePagamento;

}
