package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServicioImp implements CiudadServicio {

    private final CiudadRepo ciudadRepo;

    public CiudadServicioImp(CiudadRepo ciudadRepo) {
        this.ciudadRepo = ciudadRepo;
    }

    @Override
    public Ciudad registrarCiudad(Ciudad ciudad) throws Exception {
        Ciudad ciudadBusqueda = ciudadRepo.obtenerCiudad(ciudad.getNombre());
        if (ciudadBusqueda != null) {
            throw new Exception("La ciudad " + ciudad.getNombre() + " ya se encuentra creada");
        }
        return ciudadRepo.save(ciudad);
    }

    @Override
    public Ciudad actualizarCiudad(Ciudad ciudad) throws Exception {
        Ciudad ciudadBusqueda = ciudadRepo.obtenerCiudad(ciudad.getNombre());
        if (ciudadBusqueda != null)
            throw new Exception("La ciudad " + ciudad.getNombre() + " ya se encuentra creada");

        return ciudadRepo.save(ciudad);
    }

    @Override
    public Ciudad obtenerCiudad(int codigo) throws Exception {

        Ciudad ciudad = ciudadRepo.findById(codigo).orElse(null);
        if (ciudad == null) {
            throw new Exception("La ciudad " + codigo + " no existe");
        }
        return ciudad;
    }

    @Override
    public void eliminarCiudad(int codigo) throws Exception {

        Ciudad ciudad = ciudadRepo.findById(codigo).orElse(null);
        if (ciudad != null) {
            ciudadRepo.delete(ciudad);
        } else {
            throw new Exception("El codigo de la ciudad no existen");
        }
    }

    @Override
    public List<Ciudad> listarCiudades() {

        List<Ciudad> listaCiudades = ciudadRepo.obtenerCiudades();
        return listaCiudades;
    }
}
