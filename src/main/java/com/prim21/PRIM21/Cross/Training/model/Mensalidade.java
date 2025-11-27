package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.StatusPagamento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "mensalidade")
public class Mensalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plano;

    private Double valor;

    private LocalDate dataVencimento;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Mensalidade() {
    }

    public Mensalidade(Long id, String plano, Double valor, LocalDate dataVencimento,
                       StatusPagamento status, Aluno aluno) {
        this.id = id;
        this.plano = plano;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.status = status;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
