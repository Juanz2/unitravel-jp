package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Habitacion;

import java.util.List;

public interface HabitacionServicio {

    Habitacion registrarHabitacion(Habitacion habitacion) throws Exception;
    Habitacion actualizarHabitacion (Habitacion habitacion) throws Exception;
    Habitacion obtenerHabitacion (int codigo) throws Exception;
    void eliminarVuelo (int codigo) throws Exception;

    List<Habitacion> obtenerHabitacion ();
}
