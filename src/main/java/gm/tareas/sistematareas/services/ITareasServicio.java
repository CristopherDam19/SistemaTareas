package gm.tareas.sistematareas.services;

import gm.tareas.sistematareas.model.Tarea;

import java.util.List;

public interface ITareasServicio  {

    public List<Tarea> getTareas();

    public Tarea buscarTareaPorId(Integer idTarea);

    public void guardarTarea(Tarea tarea);

    public void eliminarTareaPorId(Integer idTarea);

}
