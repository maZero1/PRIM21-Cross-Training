package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.MatriculaHorario;
import com.prim21.PRIM21.Cross.Training.repository.MatriculaHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaHorarioService {

    @Autowired
    private MatriculaHorarioRepository matriculaHorarioRepository;

    public MatriculaHorario salvar(MatriculaHorario matricula) {
        return matriculaHorarioRepository.save(matricula);
    }

    public List<MatriculaHorario> listar() {
        return matriculaHorarioRepository.findAll();
    }

    public List<MatriculaHorario> buscarPorAluno(Long alunoId) {
        return matriculaHorarioRepository.findByAlunoId(alunoId);
    }

    public List<MatriculaHorario> buscarPorHorario(Long horarioId) {
        return matriculaHorarioRepository.findByHorarioId(horarioId);
    }
}
