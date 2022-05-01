package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.NivelAcceso;
import co.edu.uniquindio.unitravel.repositorios.NivelAccesoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelAccesoServicioImp implements NivelAccesoServicio{

    private final NivelAccesoRepo nivelAccesoRepo;

    public NivelAccesoServicioImp(NivelAccesoRepo nivelAccesoRepo) {
        this.nivelAccesoRepo = nivelAccesoRepo;
    }


    @Override
    public NivelAcceso registrarNivelAcceso(NivelAcceso nivelAcceso) throws Exception {
        NivelAcceso nivelAccesoBusqueda = nivelAccesoRepo.obtenerNivelAccesoPorNombre(nivelAcceso.getNombre());
        if(nivelAccesoBusqueda != null)
            throw new Exception("El nivel de acceso " + nivelAcceso.getNombre() +" ya existe");
        return nivelAccesoRepo.save(nivelAcceso);
    }

    @Override
    public NivelAcceso actualizarNivelAcceso(NivelAcceso nivelAcceso) throws Exception {
        NivelAcceso nivelAccesoBusqueda = nivelAccesoRepo.obtenerNivelAccesoPorNombre(nivelAcceso.getNombre());
        if(nivelAccesoBusqueda != null)
            throw new Exception("El nivel de acceso " + nivelAcceso.getNombre() +" ya existe");
        return nivelAccesoRepo.save(nivelAcceso);
    }

    @Override
    public void eliminarNivelAcceso(NivelAcceso nivelAcceso) throws Exception {
        nivelAccesoRepo.save(nivelAcceso);
    }

    @Override
    public NivelAcceso obtenerNivelAcceso(int codigo) throws Exception {
        NivelAcceso nivelAcceso = nivelAccesoRepo.findById(codigo).orElse(null);
        if (nivelAcceso == null)
            throw new Exception("El nivel de acceso no se encuentra registrado");
        return nivelAcceso;
    }

    @Override
    public List<NivelAcceso> obtenerNivelesAccesos() {
        return nivelAccesoRepo.obtenerListaNivelesAcceso();
    }
}
