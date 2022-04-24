package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Vuelo;

import java.util.List;

public interface VueloServicio {

    Vuelo registrarVuelo(Vuelo vuelo) throws Exception;
    Vuelo actualizarVuelo (Vuelo vuelo);
    Vuelo obtenerVuelo (int codigo) throws Exception;
    void eliminarVuelo (int codigo) throws Exception;

    List<Vuelo> obtenerVuelos ();
}
