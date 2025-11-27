package com.prim21.PRIM21.Cross.Training.controller;

import com.prim21.PRIM21.Cross.Training.model.Administrador;
import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.service.AdministradorService;
import com.prim21.PRIM21.Cross.Training.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/login")
    public Object login(@RequestParam String email,
                        @RequestParam String senha,
                        @RequestParam String tipo) {

        if (tipo.equalsIgnoreCase("ADMIN")) {
            Administrador admin = administradorService.login(email, senha);
            if (admin != null) {
                return admin;
            }
        }

        if (tipo.equalsIgnoreCase("ALUNO")) {
            Aluno aluno = alunoService.login(email, senha);
            if (aluno != null) {
                return aluno;
            }
        }

        return null;
    }
}
