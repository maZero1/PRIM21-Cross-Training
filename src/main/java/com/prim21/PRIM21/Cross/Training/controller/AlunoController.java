package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.model.Horario;
import com.prim21.PRIM21.Cross.Training.model.Mensalidade;
import com.prim21.PRIM21.Cross.Training.model.ReposicaoAula;
import com.prim21.PRIM21.Cross.Training.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/cadastrar")
    public Aluno cadastrar(@RequestParam String nome,
                           @RequestParam String telefone,
                           @RequestParam String email) {

        return alunoService.cadastrarAluno(nome, telefone, email);
    }

    @PutMapping("/atualizar/{id}")
    public Aluno atualizar(@PathVariable int id,
                           @RequestParam String nome,
                           @RequestParam String telefone,
                           @RequestParam String email) {

        return alunoService.atualizarAluno(id, nome, telefone, email);
    }

    @GetMapping("/listar")
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable int id) {
        return alunoService.buscarPorId(id);
    }

    @GetMapping("/{id}/mensalidades-abertas")
    public List<Mensalidade> mensalidadesAbertas(@PathVariable int id) {
        return alunoService.obterMensalidadesEmAberto(id);
    }

    @GetMapping("/{id}/horarios")
    public List<Object> horarios(@PathVariable int id) {
        return alunoService.obterHorarios(id);
    }//Voltar aqui depois, List<Object>

    @PostMapping("/{id}/reposicoes")
    public ReposicaoAula solicitarReposicao(@PathVariable int id,
                                            @RequestParam Date dataOriginal,
                                            @RequestParam String motivo) {
        return alunoService.solicitarReposicao(id, dataOriginal, motivo);
    }
}
