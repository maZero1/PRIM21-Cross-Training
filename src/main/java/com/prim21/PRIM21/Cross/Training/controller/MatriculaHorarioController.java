package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.MatriculaHorario;
import com.prim21.PRIM21.Cross.Training.service.MatriculaHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
@CrossOrigin("*")
public class MatriculaHorarioController {

    @Autowired
    private MatriculaHorarioService matriculaService;

    @GetMapping
    public List<MatriculaHorario> listar() {
        return matriculaService.listar();
    }

    @GetMapping("/aluno/{id}")
    public List<MatriculaHorario> porAluno(@PathVariable Long id) {
        return matriculaService.buscarPorAluno(id);
    }

    @GetMapping("/horario/{id}")
    public List<MatriculaHorario> porHorario(@PathVariable Long id) {
        return matriculaService.buscarPorHorario(id);
    }

    @PostMapping
    public MatriculaHorario salvar(@RequestBody MatriculaHorario m) {
        return matriculaService.salvar(m);
    }
}
