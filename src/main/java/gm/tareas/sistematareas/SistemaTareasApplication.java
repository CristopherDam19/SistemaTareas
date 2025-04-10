package gm.tareas.sistematareas;

import gm.tareas.sistematareas.representacion.SistemasTareaFx;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SistemaTareasApplication {


    public static void main(String[] args) {

        //SpringApplication.run(SistemaTareasApplication.class, args);
        Application.launch(SistemasTareaFx.class, args);
    }

}
