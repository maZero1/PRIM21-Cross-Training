/**package com.prim21.PRIM21.Cross.Training;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.model.Enum.DiaSemana;
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
        // CORREÇÃO: Usando o construtor vazio ou passando 0 no ID.
        // O ideal é não passar ID nenhum e deixar o banco decidir.
        Aluno aluno = new Aluno();
        aluno.setNome("Aluno AppRunner");
        aluno.setTelefone("999999999");
        aluno.setEmail("apprunner@gmail.com");
        aluno.setDataCadastro(new Date());

        aluno.marcarComoAtivo();

        // Agora o save() vai perceber que o ID é novo e fará um INSERT
        aluno = alunoRepository.save(aluno);

        System.out.println("Aluno salvo com ID gerado: " + aluno.getId());

        System.out.println("Lista de alunos:");
        alunoRepository.findAll()
                .forEach(a -> System.out.println(a.getId() + " - " + a.getNome()));

        Horario horario = new Horario();
        horario.setDiaSemana(DiaSemana.SEGUNDA);
        horario.setHoraInicio(Time.valueOf("07:00:00"));
        horario.setHoraFim(Time.valueOf("08:00:00"));
        horario.setDescricao("Treino iniciante");

        horario = horarioRepository.save(horario);
        System.out.println("Horario salvo com ID: " + horario.getId());
    }
}**/