package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.service.HorarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioService service;

    public HorarioController(HorarioService service) {
        this.service = service;
    }

    @PostMapping
    public Horario criar(@RequestBody Horario horario) {
        return service.criar(horario);
    }

    @GetMapping
    public List<Horario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Horario buscar(@PathVariable int id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Horario atualizar(@PathVariable int id, @RequestBody Horario dados) {
        return service.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id) {
        service.excluir(id);
    }
}
