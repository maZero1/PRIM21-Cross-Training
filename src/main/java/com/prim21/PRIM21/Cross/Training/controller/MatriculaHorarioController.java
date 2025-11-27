package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.MatriculaHorario;
import com.prim21.PRIM21.Cross.Training.service.MatriculaHorarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaHorarioController {

    private final MatriculaHorarioService matriculaHorarioService;

    public MatriculaHorarioController(MatriculaHorarioService matriculaHorarioService) {
        this.matriculaHorarioService = matriculaHorarioService;
    }

    @GetMapping("/{id}")
    public MatriculaHorario buscar(@PathVariable int id) {
        return matriculaHorarioService.buscar(id);
    }

    @GetMapping("/listar")
    public List<MatriculaHorario> listar() {
        return matriculaHorarioService.listar();
    }

    @PutMapping("/{id}/ativar")
    public MatriculaHorario ativar(@PathVariable int id) {
        return matriculaHorarioService.ativar(id);
    }

    @PutMapping("/{id}/trancar")
    public MatriculaHorario trancar(@PathVariable int id) {
        return matriculaHorarioService.trancar(id);
    }

    @PutMapping("/{id}/encerrar")
    public MatriculaHorario encerrar(@PathVariable int id) {
        return matriculaHorarioService.encerrar(id);
    }
}
