package com.prim21.PRIM21.Cross.Training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prim21.PRIM21.Cross.Training.model.Enum.DiaSemana;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String horario;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    private Integer capacidade;

    @JsonIgnore
    @OneToMany(mappedBy = "horario")
    private List<Aluno> alunos;

    public Horario() {
    }

    public Horario(Long id, String horario, DiaSemana diaSemana, Integer capacidade) {
        this.id = id;
        this.horario = horario;
        this.diaSemana = diaSemana;
        this.capacidade = capacidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
