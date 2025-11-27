package com.prim21.PRIM21.Cross.Training.test;

import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.model.Enum.StatusReposicao;
import com.prim21.PRIM21.Cross.Training.repository.ReposicaoAulaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class ReposicaoAulaRepositoryTest {

    @Autowired
    private ReposicaoAulaRepository reposicaoRepository;

    @Test
    public void deveSalvarReposicao() {
        ReposicaoAula r = new ReposicaoAula();
        r.setDataOriginal(new Date());
        r.setMotivo("Faltou por doença");

        ReposicaoAula salvo = reposicaoRepository.save(r);

        Assertions.assertNotNull(salvo.getId());
        Assertions.assertEquals(StatusReposicao.SOLICITADA, salvo.getStatus());
    }

    @Test
    public void deveAprovarReposicao() {
        ReposicaoAula r = new ReposicaoAula();
        r.setDataOriginal(new Date());
        ReposicaoAula salvo = reposicaoRepository.save(r);

        salvo.aprovar(new Date());
        reposicaoRepository.save(salvo);

        Assertions.assertEquals(StatusReposicao.APROVADA, salvo.getStatus());
    }
}

