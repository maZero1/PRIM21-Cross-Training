package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.StatusAluno;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Aluno {

    private int id;
    private String nome;
    @Getter
    private String telefone;
    private String email;
    private Date dataCadastro;
    private StatusAluno status;

    private List<Mensalidade> mensalidades = new ArrayList<>();
    private List<MatriculaHorario> matriculas = new ArrayList<>();
    private List<ReposicaoAula> reposicoes = new ArrayList<>();

    public Aluno(){}

    public Aluno(int id, String nome, String telefone, String email, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public void atualizarDados(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public void marcarComoInadimplente() {
        this.status = StatusAluno.INADIMPLENTE;
    }

    public void marcarComoAtivo() {
        this.status = StatusAluno.ATIVO;
    }

    public List<Mensalidade> obterMensalidadesEmAberto() {
        return mensalidades.stream()
                .filter(m -> !m.estaPaga())
                .toList();
    }

    public List<Horario> obterHorarios() {
        return matriculas.stream()
                .filter(MatriculaHorario::estaAtiva)
                .map(MatriculaHorario::getHorario)
                .toList();
    }

    public ReposicaoAula solicitarReposicao(Date dataOriginal, String motivo) {
        ReposicaoAula r = new ReposicaoAula();
        r.setDataOriginal(dataOriginal);
        r.setMotivo(motivo);
        r.solicitar();
        reposicoes.add(r);
        return r;
    }
    public List<MatriculaHorario> getMatriculas() {
        return matriculas;
    }
    public List<ReposicaoAula> getReposicoes() {
        return reposicoes;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return id == aluno.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
