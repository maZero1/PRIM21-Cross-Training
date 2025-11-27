package com.prim21.PRIM21.Cross.Training.test;

import com.prim21.PRIM21.Cross.Training.model.MatriculaHorario;
import com.prim21.PRIM21.Cross.Training.model.Enum.SituacaoMatricula;
import com.prim21.PRIM21.Cross.Training.repository.MatriculaHorarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class MatriculaHorarioRepositoryTest {

    @Autowired
    private MatriculaHorarioRepository matriculaRepository;

    @Test
    public void deveSalvarMatricula() {
        MatriculaHorario m = new MatriculaHorario();
        m.setDataInicio(new Date());
        m.setSituacao(SituacaoMatricula.ATIVA);

        MatriculaHorario salvo = matriculaRepository.save(m);

        Assertions.assertNotNull(salvo.getId());
    }

    @Test
    public void deveTrancarMatricula() {
        MatriculaHorario m = new MatriculaHorario();
        m.setDataInicio(new Date());
        MatriculaHorario salvo = matriculaRepository.save(m);

        salvo.trancar();
        matriculaRepository.save(salvo);

        Assertions.assertEquals(SituacaoMatricula.TRANCADA, salvo.getSituacao());
    }
}

