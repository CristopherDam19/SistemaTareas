package gm.tareas.sistematareas.controlador;

import gm.tareas.sistematareas.model.Tarea;
import gm.tareas.sistematareas.services.TareaServicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.Property;
import org.springframework.stereotype.Component;


import java.net.URL;
import java.util.ResourceBundle;

@Component
public class IndexControlador implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    private TareaServicio tareaServicio;

    @FXML
    private TableView<Tarea> tableView;

    @FXML
    private TableColumn<Tarea, Integer> idTareaColumna;

    @FXML
    private TableColumn<Tarea, String> nombreTareaColumna;

    @FXML
    private TableColumn<Tarea,String> responsableTareaColumna;

    @FXML
    private TableColumn<Tarea, String> descripcionTareaColumna;

    @FXML
    private TableColumn<Tarea, String> estadoTareaColumna;

    @FXML
    private final ObservableList<Tarea> tareasList=
            FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        configurarColumnas();
        listarTareas();
    }

    private void configurarColumnas() {
        idTareaColumna.setCellValueFactory(new PropertyValueFactory<>("idTarea"));
        nombreTareaColumna.setCellValueFactory(new PropertyValueFactory<>("nombreTarea"));
        responsableTareaColumna.setCellValueFactory(new PropertyValueFactory<>("responsableTarea"));
        descripcionTareaColumna.setCellValueFactory(new PropertyValueFactory<>("descripcionTarea"));
        estadoTareaColumna.setCellValueFactory(new PropertyValueFactory<>("estadoTarea"));
    }

    private void listarTareas() {
        logger.info("Ejecutando listando tareas");
        tareasList.clear();
        tareasList.addAll(tareaServicio.getTareas());
        tableView.setItems(tareasList);


    }
}
