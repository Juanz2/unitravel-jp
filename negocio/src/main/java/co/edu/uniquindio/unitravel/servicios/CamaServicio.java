package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cama;

import java.util.List;

public interface CamaServicio {


    Cama registrarCama(Cama cama);

    Cama obtenerCama(Integer idCama);

    List<Cama> obtenerListaCamas();

    List<Cama> obtenerCamasHabitacion(Integer idHabitacion);
}
