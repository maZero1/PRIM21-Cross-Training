package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.repository.ReposicaoAulaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReposicaoAulaService {

    private final ReposicaoAulaRepository reposicaoAulaRepository;

    public ReposicaoAulaService(ReposicaoAulaRepository reposicaoAulaRepository) {
        this.reposicaoAulaRepository = reposicaoAulaRepository;
    }

    public ReposicaoAula buscar(int id) {
        return reposicaoAulaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reposição não encontrada"));
    }

    public List<ReposicaoAula> listar() {
        return reposicaoAulaRepository.findAll();
    }

    public ReposicaoAula aprovar(int id, Date dataReposicao) {
        ReposicaoAula r = buscar(id);
        r.aprovar(dataReposicao);
        return reposicaoAulaRepository.save(r);
    }

    public ReposicaoAula registrarRealizacao(int id) {
        ReposicaoAula r = buscar(id);
        r.registrarRealizacao();
        return reposicaoAulaRepository.save(r);
    }

    public ReposicaoAula cancelar(int id, String motivo) {
        ReposicaoAula r = buscar(id);
        r.cancelar(motivo);
        return reposicaoAulaRepository.save(r);
    }
}
