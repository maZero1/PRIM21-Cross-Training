package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.service.ReposicaoAulaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reposicoes")
public class ReposicaoAulaController {

    private final ReposicaoAulaService reposicaoService;

    public ReposicaoAulaController(ReposicaoAulaService reposicaoService) {
        this.reposicaoService = reposicaoService;
    }

    // -------------------------
    // 1) Solicitar reposição
    // -------------------------

    @PostMapping("/solicitar")
    public ResponseEntity<ReposicaoAula> solicitarReposicao(
            @RequestParam Date dataOriginal,
            @RequestParam String motivo
    ) {
        ReposicaoAula r = reposicaoService.solicitarReposicao(dataOriginal, motivo);
        return ResponseEntity.ok(r);
    }

    // -------------------------
    // 2) Aprovar reposição
    // -------------------------

    @PutMapping("/{id}/aprovar")
    public ResponseEntity<ReposicaoAula> aprovarReposicao(
            @PathVariable int id,
            @RequestParam Date novaData
    ) {
        ReposicaoAula r = reposicaoService.aprovar(id, novaData);
        return ResponseEntity.ok(r);
    }

    // -------------------------
    // 3) Registrar realização
    // -------------------------

    @PutMapping("/{id}/realizar")
    public ResponseEntity<ReposicaoAula> registrarRealizacao(
            @PathVariable int id
    ) {
        ReposicaoAula r = reposicaoService.registrarRealizacao(id);
        return ResponseEntity.ok(r);
    }

    // -------------------------
    // 4) Cancelar reposição
    // -------------------------

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<ReposicaoAula> cancelarReposicao(
            @PathVariable int id,
            @RequestParam String motivo
    ) {
        ReposicaoAula r = reposicaoService.cancelar(id, motivo);
        return ResponseEntity.ok(r);
    }

    // -------------------------
    // 5) Listar todas
    // -------------------------

    @GetMapping
    public ResponseEntity<List<ReposicaoAula>> listarTodas() {
        return ResponseEntity.ok(reposicaoService.listarTodos());
    }

    // -------------------------
    // 6) Listar somente solicitadas
    // -------------------------

    @GetMapping("/solicitadas")
    public ResponseEntity<List<ReposicaoAula>> listarSolicitadas() {
        return ResponseEntity.ok(reposicaoService.listarSolicitadas());
    }
}
