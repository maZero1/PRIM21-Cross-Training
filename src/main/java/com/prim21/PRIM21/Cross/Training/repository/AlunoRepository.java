package com.prim21.PRIM21.Cross.Training.repository;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByEmail(String email);

    List<Aluno> findByHorarioId(Long horarioId);
}
