package com.prim21.PRIM21.Cross.Training;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.model.Enum.StatusAluno;
import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import com.prim21.PRIM21.Cross.Training.model.MatriculaHorario;
import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.model.Enum.SituacaoMatricula;
import com.prim21.PRIM21.Cross.Training.model.Enum.StatusPagamento;
import com.prim21.PRIM21.Cross.Training.model.Enum.StatusReposicao;
import com.prim21.PRIM21.Cross.Training.repository.AlunoRepository;
import com.prim21.PRIM21.Cross.Training.repository.HorarioRepository;
import com.prim21.PRIM21.Cross.Training.repository.MensalidadeRepository;
import com.prim21.PRIM21.Cross.Training.repository.MatriculaHorarioRepository;
import com.prim21.PRIM21.Cross.Training.repository.ReposicaoAulaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Component
public class AppRunner implements CommandLineRunner {

    private final AlunoRepository alunoRepository;
    private final HorarioRepository horarioRepository;
    private final MensalidadeRepository mensalidadeRepository;
    private final MatriculaHorarioRepository matriculaHorarioRepository;
    private final ReposicaoAulaRepository reposicaoAulaRepository;

    public AppRunner(AlunoRepository alunoRepository,
                     HorarioRepository horarioRepository,
                     MensalidadeRepository mensalidadeRepository,
                     MatriculaHorarioRepository matriculaHorarioRepository,
                     ReposicaoAulaRepository reposicaoAulaRepository) {
        this.alunoRepository = alunoRepository;
        this.horarioRepository = horarioRepository;
        this.mensalidadeRepository = mensalidadeRepository;
        this.matriculaHorarioRepository = matriculaHorarioRepository;
        this.reposicaoAulaRepository = reposicaoAulaRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("==== INICIO DOS TESTES JPA ====");

        // ALUNO - save / findAll / findById
        Aluno aluno = new Aluno();
        aluno.setNome("Aluno Runner");
        aluno.setTelefone("999999999");
        aluno.setEmail("runner@teste.com");
        aluno.setDataCadastro(new Date());
        aluno.setStatus(StatusAluno.ATIVO);

        aluno = alunoRepository.save(aluno);
        System.out.println("Aluno salvo com ID: " + aluno.getId());

        System.out.println("Lista de alunos:");
        alunoRepository.findAll()
                .forEach(a -> System.out.println(a.getId() + " - " + a.getNome()));

        alunoRepository.findById(aluno.getId()).ifPresent(
                a -> System.out.println("Aluno encontrado por ID: " + a.getNome())
        );

        // HORARIO
        Horario horario = new Horario();
        horario.setDiaSemana("SEGUNDA");
        horario.setHoraInicio(Time.valueOf("08:00:00"));
        horario.setHoraFim(Time.valueOf("09:00:00"));
        horario.setDescricao("Treino funcional");

        horario = horarioRepository.save(horario);
        System.out.println("Horário salvo com ID: " + horario.getId());

        // MENSALIDADE
        Mensalidade mensalidade = new Mensalidade();
        mensalidade.setMesReferencia("11/2025");
        mensalidade.setDataVencimento(new Date());
        mensalidade.setValor(120.0);
        mensalidade.setStatusPagamento(StatusPagamento.PENDENTE);

        mensalidade = mensalidadeRepository.save(mensalidade);
        System.out.println("Mensalidade salva com ID: " + mensalidade.getId());

        // MATRICULA HORARIO
        MatriculaHorario matricula = new MatriculaHorario();
        matricula.setDataInicio(new Date());
        matricula.setSituacao(SituacaoMatricula.ATIVA);
        matricula.setHorario(horario);

        matricula = matriculaHorarioRepository.save(matricula);
        System.out.println("Matrícula salva com ID: " + matricula.getId());

        // REPOSIÇÃO AULA
        ReposicaoAula reposicao = new ReposicaoAula();
        reposicao.setDataOriginal(new Date());
        reposicao.setMotivo("Falta justificada");
        reposicao.setStatus(StatusReposicao.SOLICITADA);

        reposicao = reposicaoAulaRepository.save(reposicao);
        System.out.println("Reposição salva com ID: " + reposicao.getId());

        System.out.println("==== FIM DOS TESTES JPA ====");
    }
}
