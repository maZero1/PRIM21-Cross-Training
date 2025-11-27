package com.prim21.PRIM21.Cross.Training.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Administrador {

    private int id;
    private String nome;
    private String email;
    private String senha;

    private List<Aluno> alunos = new ArrayList<>();
    private List<Horario> horarios = new ArrayList<>();

    public Administrador() {}

    public Administrador(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void cadastrarAluno(Aluno aluno) {
        aluno.marcarComoAtivo();
        alunos.add(aluno);
    }

    public void atualizarAluno(Aluno dadosNovos) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == dadosNovos.getId()) {
                aluno.atualizarDados(
                        dadosNovos.getNome(),
                        dadosNovos.getTelefone(),
                        dadosNovos.getEmail()
                );
                return;
            }
        }
    }

    public void registrarPagamento(Mensalidade mensalidade, Date data) {
        mensalidade.registrarPagamento(data);
    }

    public void criarHorario(Horario horario) {
        horarios.add(horario);
    }

    public MatriculaHorario agendarAlunoEmHorario(Aluno aluno, Horario horario) {
        MatriculaHorario matricula = new MatriculaHorario();
        aluno.getMatriculas().add(matricula);
        return matricula;
    }

    public void registrarReposicao(Aluno aluno, ReposicaoAula reposicao) {
        aluno.getReposicoes().add(reposicao);
    }

    public List<Aluno> gerarRelatorioInadimplentes() {
        return alunos.stream()
                .filter(a -> !a.obterMensalidadesEmAberto().isEmpty())
                .toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrador that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
