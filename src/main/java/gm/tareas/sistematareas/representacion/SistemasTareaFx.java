package gm.tareas.sistematareas.representacion;

import gm.tareas.sistematareas.SistemaTareasApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class SistemasTareaFx extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        // Inicializar Spring Boot en el método init()
        applicationContext = new SpringApplicationBuilder(SistemaTareasApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Cargar el FXML usando el ClassLoader de Spring
        FXMLLoader loader = new FXMLLoader(
                SistemaTareasApplication.class.getResource("/templates/index.fxml"));
        loader.setControllerFactory(applicationContext::getBean);

        Parent root = loader.load();

        stage.setScene(new Scene(root));
        stage.setTitle("Sistema de Tareas");
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        // Cerrar el contexto de Spring correctamente
        applicationContext.close();
        Platform.exit();
    }
}