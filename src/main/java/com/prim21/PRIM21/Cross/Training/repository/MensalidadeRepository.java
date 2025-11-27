package com.prim21.PRIM21.Cross.Training.repository;

import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long> {

    List<Mensalidade> findByAlunoId(Long alunoId);
}
