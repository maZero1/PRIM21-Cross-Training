package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.MatriculaHorario;
import com.prim21.PRIM21.Cross.Training.repository.MatriculaHorarioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MatriculaHorarioService {

    private final MatriculaHorarioRepository matriculaHorarioRepository;

    public MatriculaHorarioService(MatriculaHorarioRepository matriculaHorarioRepository) {
        this.matriculaHorarioRepository = matriculaHorarioRepository;
    }

    public MatriculaHorario buscar(int id) {
        return matriculaHorarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matrícula não encontrada"));
    }

    public List<MatriculaHorario> listar() {
        return matriculaHorarioRepository.findAll();
    }

    public MatriculaHorario ativar(int id) {
        MatriculaHorario m = buscar(id);
        m.ativar();
        return matriculaHorarioRepository.save(m);
    }

    public MatriculaHorario trancar(int id) {
        MatriculaHorario m = buscar(id);
        m.trancar();
        return matriculaHorarioRepository.save(m);
    }

    public MatriculaHorario encerrar(int id) {
        MatriculaHorario m = buscar(id);
        m.encerrar(new Date());
        return matriculaHorarioRepository.save(m);
    }
}
