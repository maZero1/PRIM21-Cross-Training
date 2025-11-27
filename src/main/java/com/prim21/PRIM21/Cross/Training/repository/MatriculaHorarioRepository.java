package com.prim21.PRIM21.Cross.Training.repository;

import com.prim21.PRIM21.Cross.Training.model.MatriculaHorario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaHorarioRepository extends JpaRepository<MatriculaHorario, Long> {

    List<MatriculaHorario> findByAlunoId(Long alunoId);

    List<MatriculaHorario> findByHorarioId(Long horarioId);
}
