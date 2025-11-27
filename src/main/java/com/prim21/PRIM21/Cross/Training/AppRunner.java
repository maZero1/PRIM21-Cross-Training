package com.prim21.PRIM21.Cross.Training;

import com.prim21.PRIM21.Cross.Training.model.*;
import com.prim21.PRIM21.Cross.Training.model.Enum.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Component
public class AppRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {

        Administrador admin = new Administrador();

        Horario h1 = new Horario();
        h1.atualizarHorario(
                DiaSemana.SEGUNDA,
                Time.valueOf("08:00:00"),
                Time.valueOf("09:00:00")
        );
        admin.criarHorario(h1);

        Aluno aluno = new Aluno();
        aluno.atualizarDados("Marlon", "9999-1234", "marlon@email.com");
        admin.cadastrarAluno(aluno);

        Mensalidade mensalidade = new Mensalidade();
        admin.registrarPagamento(mensalidade, new Date());

        admin.agendarAlunoEmHorario(aluno, h1);

        ReposicaoAula reposicao = aluno.solicitarReposicao(new Date(), "Falta por saúde");
        admin.registrarReposicao(aluno, reposicao);

        var inadimplentes = admin.gerarRelatorioInadimplentes();
        System.out.println("Inadimplentes: " + inadimplentes.size());
    }
}
