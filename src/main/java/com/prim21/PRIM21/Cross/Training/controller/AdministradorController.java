package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import com.prim21.PRIM21.Cross.Training.model.MatriculaHorario;
import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.service.AdministradorService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdministradorController {

    private final AdministradorService service;

    public AdministradorController(AdministradorService service) {
        this.service = service;
    }

    @PostMapping("/alunos")
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return service.cadastrarAluno(aluno);
    }

    @PutMapping("/alunos/{id}")
    public Aluno atualizarAluno(@PathVariable int id, @RequestBody Aluno dados) {
        return service.atualizarAluno(id, dados);
    }

    @PostMapping("/horarios")
    public Horario criarHorario(@RequestBody Horario horario) {
        return service.criarHorario(horario);
    }

    @PostMapping("/matriculas")
    public MatriculaHorario matricular(
            @RequestParam int alunoId,
            @RequestParam int horarioId
    ) {
        return service.matricular(alunoId, horarioId);
    }

    @PostMapping("/reposicoes/{idAluno}")
    public ReposicaoAula adicionarReposicao(
            @PathVariable int idAluno,
            @RequestBody ReposicaoAula reposicao
    ) {
        return service.adicionarReposicao(idAluno, reposicao);
    }

    @GetMapping("/relatorio/inadimplentes")
    public List<Aluno> listarInadimplentes() {
        return service.listarInadimplentes();
    }
}
