package com.prim21.PRIM21.Cross.Training.repository;

import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReposicaoAulaRepository extends JpaRepository<ReposicaoAula, Long> {

    List<ReposicaoAula> findByAlunoId(Long alunoId);
}
