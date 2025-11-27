package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.repository.ReposicaoAulaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReposicaoAulaService {

    private final ReposicaoAulaRepository repository;

    public ReposicaoAulaService(ReposicaoAulaRepository repository) {
        this.repository = repository;
    }

    public List<ReposicaoAula> listar() {
        return repository.findAll();
    }

    public ReposicaoAula buscar(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reposição não encontrada"));
    }

    public ReposicaoAula aprovar(int id) {
        ReposicaoAula r = buscar(id);
        r.aprovar();
        return repository.save(r);
    }

    public ReposicaoAula realizar(int id) {
        ReposicaoAula r = buscar(id);
        r.registrarRealizacao(new Date());
        return repository.save(r);
    }

    public ReposicaoAula cancelar(int id, String motivo) {
        ReposicaoAula r = buscar(id);
        r.cancelar(motivo);
        return repository.save(r);
    }
}
