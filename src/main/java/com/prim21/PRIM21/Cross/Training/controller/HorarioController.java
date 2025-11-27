package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.service.HorarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @PostMapping("/criar")
    public Horario criar(@RequestBody Horario horario) {
        return horarioService.criar(horario);
    }

    @GetMapping("/listar")
    public List<Horario> listar() {
        return horarioService.listar();
    }

    @GetMapping("/{id}")
    public Horario buscar(@PathVariable int id) {
        return horarioService.buscarPorId(id);
    }

    @PutMapping("/atualizar")
    public Horario atualizar(@RequestBody Horario horario) {
        return horarioService.atualizar(horario);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id) {
        horarioService.excluir(id);
    }
}
