package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.SituacaoMatricula;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "matricula_horario")
public class MatriculaHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataMatricula;

    @Enumerated(EnumType.STRING)
    private SituacaoMatricula situacao;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;

    public MatriculaHorario() {
    }

    public MatriculaHorario(Long id, LocalDate dataMatricula, SituacaoMatricula situacao,
                            Aluno aluno, Horario horario) {
        this.id = id;
        this.dataMatricula = dataMatricula;
        this.situacao = situacao;
        this.aluno = aluno;
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public SituacaoMatricula getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoMatricula situacao) {
        this.situacao = situacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
