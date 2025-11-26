package com.prim21.PRIM21.Cross.Training.model;

import com.prim21.PRIM21.Cross.Training.model.Enum.StatusAluno;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluno {

    private int id;
    private String nome;
    private String telefone;
    private String email;
    private Date dataCadastro;
    private StatusAluno status;

    private List<Mensalidade> mensalidades = new ArrayList<>();
    private List<MatriculaHorario> matriculas = new ArrayList<>();
    private List<ReposicaoAula> reposicoes = new ArrayList<>();

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
}
