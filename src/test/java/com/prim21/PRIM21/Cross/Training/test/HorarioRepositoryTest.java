package com.prim21.PRIM21.Cross.Training.test;

import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.model.Enum.DiaSemana;
import com.prim21.PRIM21.Cross.Training.repository.HorarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.List;

@SpringBootTest
public class HorarioRepositoryTest {

    @Autowired
    private HorarioRepository horarioRepository;

    @Test
    public void deveSalvarHorario() {
        Horario h = new Horario();
        h.setDiaSemana(DiaSemana.SEGUNDA);
        h.setHoraInicio(Time.valueOf("07:00:00"));
        h.setHoraFim(Time.valueOf("08:00:00"));
        h.setDescricao("Treino leve");

        Horario salvo = horarioRepository.save(h);
        Assertions.assertNotNull(salvo.getId());
    }

    @Test
    public void deveBuscarHorarioPorId() {
        Horario h = new Horario();
        h.setDiaSemana(DiaSemana.TERCA);
        h.setHoraInicio(Time.valueOf("09:00:00"));
        h.setHoraFim(Time.valueOf("10:00:00"));
        h.setDescricao("Treino moderado");

        Horario salvo = horarioRepository.save(h);

        var encontrado = horarioRepository.findById(salvo.getId());

        Assertions.assertTrue(encontrado.isPresent());
        Assertions.assertEquals(DiaSemana.TERCA, encontrado.get().getDiaSemana());
    }

    @Test
    public void deveListarHorarios() {
        horarioRepository.save(
                new Horario(
                        DiaSemana.QUARTA,
                        Time.valueOf("07:00:00"),
                        Time.valueOf("08:00:00"),
                        "Treino 1"
                )
        );

        List<Horario> horarios = horarioRepository.findAll();
        Assertions.assertFalse(horarios.isEmpty());
    }
}
