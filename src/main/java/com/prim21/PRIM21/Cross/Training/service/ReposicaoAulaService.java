package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.repository.ReposicaoAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReposicaoAulaService {

    @Autowired
    private ReposicaoAulaRepository reposicaoAulaRepository;

    public ReposicaoAula salvar(ReposicaoAula reposicao) {
        return reposicaoAulaRepository.save(reposicao);
    }

    public List<ReposicaoAula> listar() {
        return reposicaoAulaRepository.findAll();
    }

    public List<ReposicaoAula> listarPorAluno(Long alunoId) {
        return reposicaoAulaRepository.findByAlunoId(alunoId);
    }

    public ReposicaoAula buscar(Long id) {
        return reposicaoAulaRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        reposicaoAulaRepository.deleteById(id);
    }
}
