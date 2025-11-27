package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.MatriculaHorario;
import com.prim21.PRIM21.Cross.Training.service.MatriculaHorarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaHorarioController {

    private final MatriculaHorarioService service;

    public MatriculaHorarioController(MatriculaHorarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<MatriculaHorario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public MatriculaHorario buscar(@PathVariable int id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}/ativar")
    public MatriculaHorario ativar(@PathVariable int id) {
        return service.ativar(id);
    }

    @PutMapping("/{id}/trancar")
    public MatriculaHorario trancar(@PathVariable int id) {
        return service.trancar(id);
    }

    @PutMapping("/{id}/encerrar")
    public MatriculaHorario encerrar(@PathVariable int id) {
        return service.encerrar(id);
    }
}
