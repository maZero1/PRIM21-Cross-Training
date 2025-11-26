package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.StatusPagamento;
import java.util.Date;

public class Mensalidade {

    private int id;
    private String mesReferencia;
    private Date dataVencimento;
    private double valor;
    private StatusPagamento statusPagamento;
    private Date dataPagamento;

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
}
