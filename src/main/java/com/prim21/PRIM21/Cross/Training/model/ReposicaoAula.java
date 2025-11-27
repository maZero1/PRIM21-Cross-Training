package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.StatusReposicao;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reposicao_aula")
public class ReposicaoAula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private StatusReposicao status;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public ReposicaoAula() {
    }

    public ReposicaoAula(Long id, LocalDate data, String motivo, StatusReposicao status, Aluno aluno) {
        this.id = id;
        this.data = data;
        this.motivo = motivo;
        this.status = status;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public StatusReposicao getStatus() {
        return status;
    }

    public void setStatus(StatusReposicao status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
