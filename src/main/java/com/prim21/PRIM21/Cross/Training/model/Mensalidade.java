package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.StatusPagamento;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Mensalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String mesReferencia;

    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    private Double valor;

    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    public Mensalidade() {
    }

    public Mensalidade(int id, String mesReferencia, Date dataVencimento, Double valor, StatusPagamento statusPagamento) {
        this.id = id;
        this.mesReferencia = mesReferencia;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.statusPagamento = statusPagamento;
    }

    public void registrarPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
        this.statusPagamento = StatusPagamento.PAGO;
    }

    public void marcarComoAtrasada() {
        this.statusPagamento = StatusPagamento.ATRASADO;
    }

    public boolean estaPaga() {
        return StatusPagamento.PAGO.equals(this.statusPagamento);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mensalidade that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
