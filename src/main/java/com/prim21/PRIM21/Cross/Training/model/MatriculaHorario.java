package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.SituacaoMatricula;
import java.util.Date;
import java.util.Objects;

public class MatriculaHorario {

    private int id;
    private Date dataInicio;
    private Date dataFim;
    private SituacaoMatricula situacao;
    private Horario horario;

    public MatriculaHorario() {}

    public MatriculaHorario(int id, Date dataInicio,  Date dataFim, SituacaoMatricula situacao) {
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
