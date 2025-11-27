package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import com.prim21.PRIM21.Cross.Training.repository.MensalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensalidadeService {

    @Autowired
    private MensalidadeRepository mensalidadeRepository;

    public Mensalidade salvar(Mensalidade mensalidade) {
        return mensalidadeRepository.save(mensalidade);
    }

    public List<Mensalidade> listar() {
        return mensalidadeRepository.findAll();
    }

    public List<Mensalidade> listarPorAluno(Long alunoId) {
        return mensalidadeRepository.findByAlunoId(alunoId);
    }

    public Mensalidade buscar(Long id) {
        return mensalidadeRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        mensalidadeRepository.deleteById(id);
    }
}
