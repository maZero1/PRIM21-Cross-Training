package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import com.prim21.PRIM21.Cross.Training.service.MensalidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensalidades")
public class MensalidadeController {

    private final MensalidadeService service;

    public MensalidadeController(MensalidadeService service) {
        this.service = service;
    }

    @PostMapping
    public Mensalidade criar(@RequestBody Mensalidade mensalidade) {
        return service.criar(mensalidade);
    }

    @GetMapping
    public List<Mensalidade> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Mensalidade buscar(@PathVariable int id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}/pagar")
    public Mensalidade registrarPagamento(@PathVariable int id) {
        return service.registrarPagamento(id);
    }
}
