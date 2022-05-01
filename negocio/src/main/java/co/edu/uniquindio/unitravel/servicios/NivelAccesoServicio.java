package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.NivelAcceso;


import java.util.List;

public interface NivelAccesoServicio {

    NivelAcceso registrarNivelAcceso (NivelAcceso nivelAcceso) throws  Exception;
    NivelAcceso actualizarNivelAcceso (NivelAcceso nivelAcceso)  throws  Exception;
    void eliminarNivelAcceso  (NivelAcceso nivelAcceso)  throws  Exception;
    NivelAcceso obtenerNivelAcceso (int codigo) throws  Exception;
    List<NivelAcceso> obtenerNivelesAccesos();
}
