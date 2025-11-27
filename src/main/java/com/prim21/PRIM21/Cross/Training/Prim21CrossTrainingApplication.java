package com.prim21.PRIM21.Cross.Training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Prim21CrossTrainingApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Prim21CrossTrainingApplication.class);

        app.addListeners((ApplicationListener<ApplicationReadyEvent>) event -> {
            Environment env = event.getApplicationContext().getEnvironment();
            String port = env.getProperty("server.port", "8080");

            System.out.println("\n=========================================================");
            System.out.println("  🚀 Aplicação iniciada com sucesso!");
            System.out.println("  ▶ Acesse em: http://localhost:" + port);
            System.out.println("=========================================================\n");
        });

        app.run(args);
    }
}
