package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.DiaSemana;
import java.sql.Time;

public class Horario {

    private int id;
    private DiaSemana diaSemana;
    private Time horaInicio;
    private Time horaFim;
    private String descricao;

    public void atualizarHorario(DiaSemana diaSemana, Time horaInicio, Time horaFim) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public boolean contemHorario(Time hora) {
        return !hora.before(horaInicio) && !hora.after(horaFim);
    }
}
