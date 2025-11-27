package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno) {
        aluno.marcarComoAtivo();
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(int id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public Aluno atualizar(int id, Aluno dados) {
        Aluno aluno = buscarPorId(id);

        aluno.setNome(dados.getNome());
        aluno.setTelefone(dados.getTelefone());
        aluno.setEmail(dados.getEmail());
        aluno.setStatus(dados.getStatus());

        return alunoRepository.save(aluno);
    }

    public void excluir(int id) {
        alunoRepository.deleteById(id);
    }
}
