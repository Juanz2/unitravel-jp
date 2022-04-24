package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Ciudad;

import java.util.List;

public interface CiudadServicio {

    Ciudad registrarCiudad(Ciudad ciudad) throws Exception;
    Ciudad actualizarCiudad (Ciudad ciudad);
    Ciudad obtenerCiudad (int codigo) throws  Exception;
    void eliminarCiudad (int codigo) throws  Exception;
    List<Ciudad> listarCiudades() ;
}
