package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno login(String email, String senha) {
        Aluno aluno = alunoRepository.findByEmail(email);

        if (aluno != null && aluno.getSenha().equals(senha)) {
            return aluno;
        }

        return null;
    }
}
