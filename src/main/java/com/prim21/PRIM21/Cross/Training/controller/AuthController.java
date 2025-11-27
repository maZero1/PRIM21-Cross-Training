package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.model.dto.RegistrarDTO;
import com.prim21.PRIM21.Cross.Training.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AlunoRepository alunoRepository;
//espera p arrumar esse, n sei se é necessario, to pensando
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody RegistrarDTO dto) {

        // Verifica duplicidade de e-mail
        if (alunoRepository.existsByEmail(dto.getEmail())) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "sucesso", false,
                            "mensagem", "E-mail já está cadastrado"
                    )
            );
        }

        // Cria objeto aluno
        Aluno novo = new Aluno();
        novo.setNome(dto.getNome());
        novo.setEmail(dto.getEmail());
        novo.setSenha(passwordEncoder.encode(dto.getSenha()));

        alunoRepository.save(novo);

        return ResponseEntity.ok(
                Map.of(
                        "sucesso", true,
                        "mensagem", "Conta criada com sucesso!"
                )
        );
    }
}
