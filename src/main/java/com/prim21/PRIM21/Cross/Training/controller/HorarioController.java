package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.service.AlunoService;
import com.prim21.PRIM21.Cross.Training.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
@CrossOrigin("*")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Horario> listar() {
        return horarioService.listar();
    }

    @GetMapping("/{id}")
    public Horario buscar(@PathVariable Long id) {
        return horarioService.buscar(id);
    }

    @PostMapping
    public Horario salvar(@RequestBody Horario horario) {
        return horarioService.salvar(horario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        horarioService.deletar(id);
    }

    @GetMapping("/{id}/alunos")
    public List<?> listarAlunosDoHorario(@PathVariable Long id) {
        return alunoService.listar().stream()
                .filter(a -> a.getHorario() != null && a.getHorario().getId().equals(id))
                .toList();
    }
}
