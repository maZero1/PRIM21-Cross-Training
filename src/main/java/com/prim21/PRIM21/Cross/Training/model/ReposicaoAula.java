package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.StatusReposicao;
import java.util.Date;

public class ReposicaoAula {

    private int id;
    private Date dataOriginal;
    private Date dataReposicao;
    private String motivo;
    private StatusReposicao status;

    public void aprovar(Date dataReposicao) {
        this.dataReposicao = dataReposicao;
        this.status = StatusReposicao.APROVADA;
    }

    public void registrarRealizacao() {
        this.status = StatusReposicao.REALIZADA;
    }

    public void cancelar(String motivo) {
        this.motivo = motivo;
        this.status = StatusReposicao.CANCELADA;
    }

    public boolean estaAprovada() {
        return status == StatusReposicao.APROVADA;
    }

    public boolean estaRealizada() {
        return status == StatusReposicao.REALIZADA;
    }

    public void solicitar() {
        this.status = StatusReposicao.SOLICITADA;
    }

    public void setDataOriginal(Date dataOriginal) {
        this.dataOriginal = dataOriginal;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
