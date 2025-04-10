package gm.tareas.sistematareas.services;

import gm.tareas.sistematareas.model.Tarea;
import gm.tareas.sistematareas.repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicio implements ITareasServicio {

    @Autowired
    private TareaRepositorio tareaRepositorio;

    @Override
    public List<Tarea> getTareas() {
        return tareaRepositorio.findAll();
    }

    @Override
    public Tarea buscarTareaPorId(Integer idTarea) {
        return tareaRepositorio.findById(idTarea).orElse(null);

    }

    @Override
    public void guardarTarea(Tarea tarea) {
        tareaRepositorio.save(tarea);

    }

    @Override
    public void eliminarTareaPorId(Integer idTarea) {
        tareaRepositorio.deleteById(idTarea);

    }
}
