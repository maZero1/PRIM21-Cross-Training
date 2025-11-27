package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.service.ReposicaoAulaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reposicoes")
public class ReposicaoAulaController {

    private final ReposicaoAulaService service;

    public ReposicaoAulaController(ReposicaoAulaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReposicaoAula> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ReposicaoAula buscar(@PathVariable int id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}/aprovar")
    public ReposicaoAula aprovar(@PathVariable int id) {
        return service.aprovar(id);
    }

    @PutMapping("/{id}/realizar")
    public ReposicaoAula registrarRealizacao(@PathVariable int id) {
        return service.realizar(id);
    }

    @PutMapping("/{id}/cancelar")
    public ReposicaoAula cancelar(@PathVariable int id, @RequestParam String motivo) {
        return service.cancelar(id, motivo);
    }
}
