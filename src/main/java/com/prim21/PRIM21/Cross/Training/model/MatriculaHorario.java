package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.SituacaoMatricula;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class MatriculaHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @Enumerated(EnumType.STRING)
    private SituacaoMatricula situacao;

    public MatriculaHorario() {
    }

    public MatriculaHorario(int id, Date dataInicio, Date dataFim, SituacaoMatricula situacao) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.situacao = situacao;
    }

    public void ativar() {
        this.situacao = SituacaoMatricula.ATIVA;
    }

    public void trancar() {
        this.situacao = SituacaoMatricula.TRANCADA;
    }

    public void encerrar(Date dataFim) {
        this.dataFim = dataFim;
        this.situacao = SituacaoMatricula.ENCERRADA;
    }

    public boolean estaAtiva() {
        return situacao == SituacaoMatricula.ATIVA;
    }

    public int getId() {
        return id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public SituacaoMatricula getSituacao() {
        return situacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setSituacao(SituacaoMatricula situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatriculaHorario that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
