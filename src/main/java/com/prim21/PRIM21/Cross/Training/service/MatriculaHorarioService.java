package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.MatriculaHorario;
import com.prim21.PRIM21.Cross.Training.repository.MatriculaHorarioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MatriculaHorarioService {

    private final MatriculaHorarioRepository repository;

    public MatriculaHorarioService(MatriculaHorarioRepository repository) {
        this.repository = repository;
    }

    public List<MatriculaHorario> listar() {
        return repository.findAll();
    }

    public MatriculaHorario buscar(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));
    }

    public MatriculaHorario ativar(int id) {
        MatriculaHorario m = buscar(id);
        m.ativar();
        return repository.save(m);
    }

    public MatriculaHorario trancar(int id) {
        MatriculaHorario m = buscar(id);
        m.trancar();
        return repository.save(m);
    }

    public MatriculaHorario encerrar(int id) {
        MatriculaHorario m = buscar(id);
        m.setDataFim(new Date());
        m.encerrar();
        return repository.save(m);
    }
}
