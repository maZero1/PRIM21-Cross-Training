package com.prim21.PRIM21.Cross.Training.test;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.model.Enum.StatusAluno;
import com.prim21.PRIM21.Cross.Training.repository.AlunoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;

@DataJpaTest // Usa banco H2 isolado apenas para testes
public class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    public void deveSalvarAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome("Maria");
        aluno.setTelefone("999999999");
        aluno.setEmail("maria@gmail.com");
        aluno.setDataCadastro(new Date());
        aluno.setStatus(StatusAluno.ATIVO);

        Aluno salvo = alunoRepository.save(aluno);

        Assertions.assertNotNull(salvo.getId());
    }

    @Test
    public void deveBuscarAlunoPorId() {
        Aluno aluno = new Aluno();
        aluno.setNome("Carlos");
        aluno.setTelefone("888888888");
        aluno.setEmail("carlos@gmail.com");
        aluno.setDataCadastro(new Date());
        aluno.setStatus(StatusAluno.ATIVO);

        Aluno salvo = alunoRepository.save(aluno);

        Optional<Aluno> encontrado = alunoRepository.findById(salvo.getId());

        Assertions.assertTrue(encontrado.isPresent());
        Assertions.assertEquals("Carlos", encontrado.get().getNome());
    }

    @Test
    public void deveListarTodosOsAlunos() {
        alunoRepository.save(new Aluno(99,"João", "99999", "joao@gmail.com", new Date()));
        alunoRepository.save(new Aluno(98,"Ana", "88888", "ana@gmail.com", new Date()));

        var lista = alunoRepository.findAll();
        Assertions.assertTrue(lista.size() >= 2);
    }

    @Test
    public void deveExcluirAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome("Pedro");
        aluno.setTelefone("77777777");
        aluno.setEmail("pedro@gmail.com");
        aluno.setDataCadastro(new Date());
        aluno.setStatus(StatusAluno.ATIVO);

        Aluno salvo = alunoRepository.save(aluno);
        alunoRepository.delete(salvo);

        Optional<Aluno> encontrado = alunoRepository.findById(salvo.getId());
        Assertions.assertTrue(encontrado.isEmpty());
    }
}
