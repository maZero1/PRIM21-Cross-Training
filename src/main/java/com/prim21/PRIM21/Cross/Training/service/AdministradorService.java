package com.prim21.PRIM21.Cross.Training.service;

import com.prim21.PRIM21.Cross.Training.model.Administrador;
import com.prim21.PRIM21.Cross.Training.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador login(String email, String senha) {
        Administrador admin = administradorRepository.findByEmail(email);

        if (admin != null && admin.getSenha().equals(senha)) {
            return admin;
        }

        return null;
    }
}
