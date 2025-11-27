package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.*;
import com.prim21.PRIM21.Cross.Training.repository.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdministradorService {

    private final AlunoRepository alunoRepository;
    private final MensalidadeRepository mensalidadeRepository;
    private final HorarioRepository horarioRepository;
    private final MatriculaHorarioRepository matriculaHorarioRepository;
    private final ReposicaoAulaRepository reposicaoAulaRepository;

    public AdministradorService(AlunoRepository alunoRepository,
                                MensalidadeRepository mensalidadeRepository,
                                HorarioRepository horarioRepository,
                                MatriculaHorarioRepository matriculaHorarioRepository,
                                ReposicaoAulaRepository reposicaoAulaRepository) {

        this.alunoRepository = alunoRepository;
        this.mensalidadeRepository = mensalidadeRepository;
        this.horarioRepository = horarioRepository;
        this.matriculaHorarioRepository = matriculaHorarioRepository;
        this.reposicaoAulaRepository = reposicaoAulaRepository;
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Aluno alunoAtualizado) {
        return alunoRepository.save(alunoAtualizado);
    }

    public Mensalidade registrarPagamento(int mensalidadeId, Date dataPagamento) {
        Mensalidade m = mensalidadeRepository.findById(mensalidadeId)
                .orElseThrow(() -> new IllegalArgumentException("Mensalidade não encontrada"));

        m.registrarPagamento(dataPagamento);
        return mensalidadeRepository.save(m);
    }

    public Horario criarHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public MatriculaHorario agendarAlunoEmHorario(int alunoId, int horarioId) {

        Horario horario = horarioRepository.findById(horarioId)
                .orElseThrow(() -> new IllegalArgumentException("Horário não encontrado"));

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        MatriculaHorario matricula = new MatriculaHorario();
        matricula.setDataInicio(new Date());
        matricula.ativar();

        aluno.getMatriculas().add(matricula);

        alunoRepository.save(aluno);
        matriculaHorarioRepository.save(matricula);

        return matricula;
    }
    public ReposicaoAula registrarReposicao(int alunoId, ReposicaoAula reposicao) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        aluno.getReposicoes().add(reposicao);
        reposicaoAulaRepository.save(reposicao);
        alunoRepository.save(aluno);

        return reposicao;
    }
    public List<Aluno> gerarRelatorioInadimplentes() {
        return alunoRepository.findAll().stream()
                .filter(a -> !a.obterMensalidadesEmAberto().isEmpty())
                .toList();
    }
}
