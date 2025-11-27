package com.prim21.PRIM21.Cross.Training;

import com.prim21.PRIM21.Cross.Training.model.Aluno;
import com.prim21.PRIM21.Cross.Training.repository.AlunoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Prim21CrossTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(Prim21CrossTrainingApplication.class, args);
    }

    @Bean
    public CommandLineRunner testRepositories(AlunoRepository alunoRepository) {
        return args -> {

            System.out.println("==== INICIO DOS TESTES ====");

            // SAVE
            Aluno aluno = new Aluno();
            aluno.setNome("Teste Repo");
            aluno.setTelefone("999999999");
            aluno.setEmail("teste@gmail.com");
            aluno.setDataCadastro(new Date());
            alunoRepository.save(aluno);
            System.out.println("Aluno salvo com ID: " + aluno.getId());

            // FIND ALL
            System.out.println("Lista de alunos:");
            alunoRepository.findAll().forEach(a ->
                    System.out.println(a.getId() + " - " + a.getNome())
            );

            // FIND BY ID
            var encontrado = alunoRepository.findById(aluno.getId());
            System.out.println("Encontrado por ID? " + encontrado.isPresent());
            encontrado.ifPresent(a ->
                    System.out.println("Aluno encontrado: " + a.getNome())
            );

            System.out.println("==== FIM DOS TESTES ====");
        };
    }


}
