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

    @ManyToOne
    private Horario horario;

    public MatriculaHorario() {
    }

    public MatriculaHorario(int id, Date dataInicio, Date dataFim, SituacaoMatricula situacao, Horario horario) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.situacao = situacao;
        this.horario = horario;
    }

    public void ativar() {
        this.situacao = SituacaoMatricula.ATIVA;
    }

    public void trancar() {
        this.situacao = SituacaoMatricula.TRANCADA;
    }

    public void encerrar() {
        this.situacao = SituacaoMatricula.ENCERRADA;
    }

    public boolean estaAtiva() {
        return this.situacao == SituacaoMatricula.ATIVA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public SituacaoMatricula getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoMatricula situacao) {
        this.situacao = situacao;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
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
