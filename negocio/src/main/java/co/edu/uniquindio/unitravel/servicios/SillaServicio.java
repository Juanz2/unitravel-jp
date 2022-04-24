package co.edu.uniquindio.unitravel.servicios;


import co.edu.uniquindio.unitravel.entidades.Silla;

import java.util.List;

public interface SillaServicio {

    Silla registrarSilla(Silla silla) throws Exception;
    Silla actualizarSilla(Silla silla) throws Exception;
    Silla obtenerSilla (int codigo) throws Exception;
    void eliminarSilla (int codigo) throws Exception;
    List<Silla> obtenerSillas ();
}
