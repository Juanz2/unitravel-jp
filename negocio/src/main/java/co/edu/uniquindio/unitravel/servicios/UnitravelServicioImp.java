package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitravelServicioImp implements UnitravelServicio{

    private final CiudadRepo ciudadRepo;

    public UnitravelServicioImp(CiudadRepo ciudadRepo) {
        this.ciudadRepo = ciudadRepo;
    }


    @Override
    public List<Ciudad> obtenerCiudades() {
        return ciudadRepo.obtenerCiudades();
    }
}
