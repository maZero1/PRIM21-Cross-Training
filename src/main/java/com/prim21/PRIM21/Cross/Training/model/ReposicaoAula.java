package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.StatusReposicao;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class ReposicaoAula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dataOriginal;

    @Temporal(TemporalType.DATE)
    private Date dataReposicao;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private StatusReposicao status;

    public ReposicaoAula() {
        this.status = StatusReposicao.SOLICITADA;
    }

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

    public int getId() { return id; }

    public Date getDataOriginal() { return dataOriginal; }

    public void setDataOriginal(Date dataOriginal) { this.dataOriginal = dataOriginal; }

    public Date getDataReposicao() { return dataReposicao; }

    public String getMotivo() { return motivo; }

    public void setMotivo(String motivo) { this.motivo = motivo; }

    public StatusReposicao getStatus() { return status; }

    public void setStatus(StatusReposicao status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReposicaoAula that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
