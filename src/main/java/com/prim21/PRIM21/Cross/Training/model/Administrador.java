package com.prim21.PRIM21.Cross.Training.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Administrador {

    private int id;
    private String nome;
    private String email;
    private String senha;

    private List<Aluno> alunos = new ArrayList<>();
    private List<Horario> horarios = new ArrayList<>();

    public void cadastrarAluno(Aluno aluno) {
        aluno.marcarComoAtivo();
        alunos.add(aluno);
    }

    public void atualizarAluno(Aluno aluno) {}

    public void registrarPagamento(Mensalidade mensalidade, Date data) {
        mensalidade.registrarPagamento(data);
    }

    public void criarHorario(Horario horario) {
        horarios.add(horario);
    }

    public MatriculaHorario agendarAlunoEmHorario(Aluno aluno, Horario horario) {
        MatriculaHorario matricula = new MatriculaHorario();
        matricula.setHorario(horario);
        matricula.ativar();
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
}
