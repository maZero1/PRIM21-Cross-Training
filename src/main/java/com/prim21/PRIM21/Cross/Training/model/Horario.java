package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.DiaSemana;
import java.sql.Time;
import java.util.Objects;

public class Horario {

    private int id;
    private DiaSemana diaSemana;
    private Time horaInicio;
    private Time horaFim;
    private String descricao;

    public Horario() {
    }

    public Horario(int id, DiaSemana diaSemana, Time horaInicio, Time horaFim, String descricao) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.descricao = descricao;
    }

    public void atualizarHorario(DiaSemana diaSemana, Time horaInicio, Time horaFim) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public boolean contemHorario(Time hora) {
        return !hora.before(horaInicio) && !hora.after(horaFim);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horario horario)) return false;
        return id == horario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
