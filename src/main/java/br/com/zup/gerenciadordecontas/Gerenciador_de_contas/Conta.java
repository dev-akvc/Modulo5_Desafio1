package br.com.zup.gerenciadordecontas.Gerenciador_de_contas;

import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciadordecontas.Gerenciador_de_contas.enuns.Tipo;
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
    private Tipo tipo;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "data_de_vencimento")
    private LocalDate dataDeVencimento;
    @Column(name = "data_de_pagamento", nullable = false)
    private LocalDateTime dataDePagamento;

}
