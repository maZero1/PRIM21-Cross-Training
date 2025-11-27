package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.DiaSemana;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Objects;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    private Time horaInicio;

    private Time horaFim;

    private String descricao;

    public Horario() {}

    public Horario(DiaSemana diaSemana, Time horaInicio, Time horaFim, String descricao) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.descricao = descricao;
    }

    public int getId() { return id; }

    public DiaSemana getDiaSemana() { return diaSemana; }

    public void setDiaSemana(DiaSemana diaSemana) { this.diaSemana = diaSemana; }

    public Time getHoraInicio() { return horaInicio; }

    public void setHoraInicio(Time horaInicio) { this.horaInicio = horaInicio; }

    public Time getHoraFim() { return horaFim; }

    public void setHoraFim(Time horaFim) { this.horaFim = horaFim; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

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
