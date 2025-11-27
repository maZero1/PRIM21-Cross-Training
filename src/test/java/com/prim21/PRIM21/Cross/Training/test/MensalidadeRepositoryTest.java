package com.prim21.PRIM21.Cross.Training.test;

import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import com.prim21.PRIM21.Cross.Training.model.Enum.StatusPagamento;
import com.prim21.PRIM21.Cross.Training.repository.MensalidadeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class MensalidadeRepositoryTest {

    @Autowired
    private MensalidadeRepository mensalidadeRepository;

    @Test
    public void deveSalvarMensalidade() {
        Mensalidade m = new Mensalidade();
        m.setMesReferencia("11/2025");
        m.setDataVencimento(new Date());
        m.setValor(120.0);
        m.setStatusPagamento(StatusPagamento.PENDENTE);

        Mensalidade salvo = mensalidadeRepository.save(m);
        Assertions.assertNotNull(salvo.getId());
    }

    @Test
    public void deveRegistrarPagamento() {
        Mensalidade m = new Mensalidade();
        m.setMesReferencia("10/2025");
        m.setDataVencimento(new Date());
        m.setValor(100.0);
        Mensalidade salvo = mensalidadeRepository.save(m);

        salvo.registrarPagamento(new Date());
        mensalidadeRepository.save(salvo);

        Assertions.assertEquals(StatusPagamento.PAGO, salvo.getStatusPagamento());
    }
}

