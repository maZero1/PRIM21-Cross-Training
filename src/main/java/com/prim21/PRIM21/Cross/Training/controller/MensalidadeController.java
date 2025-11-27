package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import com.prim21.PRIM21.Cross.Training.service.MensalidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mensalidades")
public class MensalidadeController {

    private final MensalidadeService mensalidadeService;

    public MensalidadeController(MensalidadeService mensalidadeService) {
        this.mensalidadeService = mensalidadeService;
    }

    @PostMapping("/criar")
    public Mensalidade criar(@RequestBody Mensalidade mensalidade) {
        return mensalidadeService.criar(mensalidade);
    }

    @GetMapping("/listar")
    public List<Mensalidade> listar() {
        return mensalidadeService.listarTodas();
    }

    @GetMapping("/{id}")
    public Mensalidade buscar(@PathVariable int id) {
        return mensalidadeService.buscarPorId(id);
    }

    @PutMapping("/{id}/pagar")
    public Mensalidade pagar(@PathVariable int id,
                             @RequestParam Date dataPagamento) {
        return mensalidadeService.registrarPagamento(id, dataPagamento);
    }

    @PutMapping("/{id}/atrasada")
    public Mensalidade marcarAtrasada(@PathVariable int id) {
        return mensalidadeService.marcarComoAtrasada(id);
    }
}
