package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.model.Enum.StatusReposicao;
import com.prim21.PRIM21.Cross.Training.repository.ReposicaoAulaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReposicaoAulaService {

    private final ReposicaoAulaRepository reposicaoRepository;

    public ReposicaoAulaService(ReposicaoAulaRepository reposicaoRepository) {
        this.reposicaoRepository = reposicaoRepository;
    }

    public ReposicaoAula solicitarReposicao(Date dataOriginal, String motivo) {
        ReposicaoAula r = new ReposicaoAula();
        r.setDataOriginal(dataOriginal);
        r.setMotivo(motivo);

        return reposicaoRepository.save(r);
    }

    public ReposicaoAula aprovar(int id, Date novaDataReposicao) {
        ReposicaoAula r = reposicaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reposição não encontrada"));

        r.aprovar(novaDataReposicao);

        return reposicaoRepository.save(r);
    }

    public ReposicaoAula registrarRealizacao(int id) {
        ReposicaoAula r = reposicaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reposição não encontrada"));

        r.registrarRealizacao();

        return reposicaoRepository.save(r);
    }

    public ReposicaoAula cancelar(int id, String motivoCancelamento) {
        ReposicaoAula r = reposicaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reposição não encontrada"));

        r.cancelar(motivoCancelamento);

        return reposicaoRepository.save(r);
    }

    public List<ReposicaoAula> listarTodos() {
        return reposicaoRepository.findAll();
    }

    public List<ReposicaoAula> listarSolicitadas() {
        return reposicaoRepository.findAll().stream()
                .filter(r -> r.getStatus() == StatusReposicao.SOLICITADA)
                .toList();
    }
}
