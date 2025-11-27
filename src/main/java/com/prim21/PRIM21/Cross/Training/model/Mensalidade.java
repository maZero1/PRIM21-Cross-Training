package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.StatusPagamento;
import java.util.Date;
import java.util.Objects;

public class Mensalidade {

    private int id;
    private String mesReferencia;
    private Date dataVencimento;
    private double valor;
    private StatusPagamento statusPagamento;
    private Date dataPagamento;

    public Mensalidade() {}

    public Mensalidade(int id, String mesReferencia, Date dataVencimento, double valor, StatusPagamento statusPagamento, Date dataPagamento) {
        this.id = id;
        this.mesReferencia = mesReferencia;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.statusPagamento = statusPagamento;
        this.dataPagamento = dataPagamento;
    }


    public void registrarPagamento(Date data) {
        this.dataPagamento = data;
        this.statusPagamento = StatusPagamento.PAGO;
    }

    public void marcarComoAtrasada() {
        this.statusPagamento = StatusPagamento.ATRASADO;
    }

    public boolean estaPaga() {
        return statusPagamento == StatusPagamento.PAGO;
    }

    public boolean estaAtrasada() {
        return statusPagamento == StatusPagamento.ATRASADO;
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
