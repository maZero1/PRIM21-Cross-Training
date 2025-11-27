package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.*;
import com.prim21.PRIM21.Cross.Training.repository.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdministradorService {

    private final AlunoRepository alunoRepository;
    private final HorarioRepository horarioRepository;
    private final MensalidadeRepository mensalidadeRepository;
    private final MatriculaHorarioRepository matriculaHorarioRepository;
    private final ReposicaoAulaRepository reposicaoAulaRepository;

    public AdministradorService(
            AlunoRepository alunoRepository,
            HorarioRepository horarioRepository,
            MensalidadeRepository mensalidadeRepository,
            MatriculaHorarioRepository matriculaHorarioRepository,
            ReposicaoAulaRepository reposicaoAulaRepository
    ) {
        this.alunoRepository = alunoRepository;
        this.horarioRepository = horarioRepository;
        this.mensalidadeRepository = mensalidadeRepository;
        this.matriculaHorarioRepository = matriculaHorarioRepository;
        this.reposicaoAulaRepository = reposicaoAulaRepository;
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        aluno.marcarComoAtivo();
        aluno.setDataCadastro(new Date());
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(int id, Aluno dados) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setNome(dados.getNome());
        aluno.setTelefone(dados.getTelefone());
        aluno.setEmail(dados.getEmail());
        aluno.setStatus(dados.getStatus());
        return alunoRepository.save(aluno);
    }

    public Horario criarHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public MatriculaHorario matricular(int alunoId, int horarioId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Horario horario = horarioRepository.findById(horarioId)
                .orElseThrow(() -> new RuntimeException("Horário não encontrado"));

        MatriculaHorario m = new MatriculaHorario();
        m.setDataInicio(new Date());
        m.ativar();

        aluno.getMatriculas().add(m);
        matriculaHorarioRepository.save(m);
        alunoRepository.save(aluno);

        return m;
    }

    public ReposicaoAula adicionarReposicao(int alunoId, ReposicaoAula reposicao) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.getReposicoes().add(reposicao);
        reposicaoAulaRepository.save(reposicao);
        alunoRepository.save(aluno);

        return reposicao;
    }

    public List<Aluno> listarInadimplentes() {
        return alunoRepository.findAll().stream()
                .filter(a -> !a.obterMensalidadesEmAberto().isEmpty())
                .toList();
    }
}
