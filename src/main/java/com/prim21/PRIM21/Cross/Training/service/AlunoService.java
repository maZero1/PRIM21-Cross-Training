package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.model.Enum.StatusAluno;
import com.prim21.PRIM21.Cross.Training.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno cadastrarAluno(String nome, String telefone, String email) {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
        aluno.setDataCadastro(new Date());
        aluno.setStatus(StatusAluno.ATIVO);

        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(int id, String nome, String telefone, String email) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado com id: " + id));

        aluno.atualizarDados(nome, telefone, email);
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(int id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado com id: " + id));
    }

    public List<Mensalidade> obterMensalidadesEmAberto(int alunoId) {
        Aluno aluno = buscarPorId(alunoId);
        return aluno.obterMensalidadesEmAberto();
    }

    public List<Object> obterHorarios(int alunoId) {
        Aluno aluno = buscarPorId(alunoId);
        return aluno.obterHorarios();
    }

    public ReposicaoAula solicitarReposicao(int alunoId, Date dataOriginal, String motivo) {
        Aluno aluno = buscarPorId(alunoId);
        ReposicaoAula reposicao = aluno.solicitarReposicao(dataOriginal, motivo);
        alunoRepository.save(aluno);
        return reposicao;
    }

    public void marcarComoInadimplente(int alunoId) {
        Aluno aluno = buscarPorId(alunoId);
        aluno.marcarComoInadimplente();
        alunoRepository.save(aluno);
    }

    public void marcarComoAtivo(int alunoId) {
        Aluno aluno = buscarPorId(alunoId);
        aluno.marcarComoAtivo();
        alunoRepository.save(aluno);
    }
}
