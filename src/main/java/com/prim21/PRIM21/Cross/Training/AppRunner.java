package com.prim21.PRIM21.Cross.Training;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.model.Enum.DiaSemana;
import com.prim21.PRIM21.Cross.Training.model.Enum.StatusAluno;
import com.prim21.PRIM21.Cross.Training.repository.AlunoRepository;
import com.prim21.PRIM21.Cross.Training.repository.HorarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Component
public class AppRunner implements CommandLineRunner {

    private final AlunoRepository alunoRepository;
    private final HorarioRepository horarioRepository;

    public AppRunner(AlunoRepository alunoRepository, HorarioRepository horarioRepository) {
        this.alunoRepository = alunoRepository;
        this.horarioRepository = horarioRepository;
    }

    @Override
    public void run(String... args) {
        Aluno aluno = new Aluno(100, "Aluno AppRunner", "999999999", "apprunner@gmail.com", new Date());
        aluno.marcarComoAtivo();
        aluno = alunoRepository.save(aluno);
        System.out.println("Aluno salvo com ID: " + aluno.getId());

        System.out.println("Lista de alunos:");
        alunoRepository.findAll()
                .forEach(a -> System.out.println(a.getId() + " - " + a.getNome()));

        alunoRepository.findById(aluno.getId()).ifPresent(
                a -> System.out.println("Aluno encontrado por ID: " + a.getNome())
        );

        Horario horario = new Horario();
        horario.setDiaSemana(DiaSemana.SEGUNDA);
        horario.setHoraInicio(Time.valueOf("07:00:00"));
        horario.setHoraFim(Time.valueOf("08:00:00"));
        horario.setDescricao("Treino iniciante");

        horario = horarioRepository.save(horario);
        System.out.println("Horario salvo com ID: " + horario.getId());
    }
}
