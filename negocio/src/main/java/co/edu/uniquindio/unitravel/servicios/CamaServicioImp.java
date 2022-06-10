package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.repositorios.CamaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CamaServicioImp implements CamaServicio, Serializable {


    @Autowired
    private CamaRepo camaRepo;

    @Override
    public Cama registrarCama(Cama cama) {
        return camaRepo.save(cama);
    }

    @Override
    public Cama obtenerCama(Integer idCama) {
        return camaRepo.findById(idCama).orElse(null);
    }

    @Override
    public List<Cama> obtenerListaCamas() {
        return camaRepo.obtenerListaCamas();
    }

    @Override
    public List<Cama> obtenerCamasHabitacion(Integer idHabitacion) {
        return camaRepo.obtenerCamaHabitacion(idHabitacion);
    }
}
