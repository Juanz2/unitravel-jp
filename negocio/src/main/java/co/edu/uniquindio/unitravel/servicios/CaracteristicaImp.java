package co.edu.uniquindio.unitravel.servicios;


import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.repositorios.CaracteristicaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicaImp implements CaracteristicaServicio{

    private final CaracteristicaRepo caracteristicaRepo;

    public CaracteristicaImp(CaracteristicaRepo caracteristicaRepo) {this.caracteristicaRepo = caracteristicaRepo;}

    @Override
    public Caracteristica registrarCaracteristica(Caracteristica caracteristica){
        return caracteristicaRepo.save(caracteristica);}

    @Override
    public Caracteristica actualizarCaracteristica(Caracteristica caracteristica) {
        return caracteristicaRepo.save(caracteristica);
    }

    @Override
    public Caracteristica obtenerCaracteristica(int codigo) throws Exception {
        Caracteristica caracteristica = caracteristicaRepo.findById(codigo).orElse(null);
        if (caracteristica == caracteristica){
            throw new Exception("La caracteristica "+ codigo + "no existe");
        }
        return caracteristica;
    }

    @Override
    public void eliminarCaracteristica(int codigo) throws Exception {
        Caracteristica caracteristica = caracteristicaRepo.findById(codigo).orElse(null);
        if(caracteristica == null){
            throw new Exception("la caracteristica " + codigo + "no existe");
        }
        caracteristicaRepo.delete(caracteristica);
    }

    @Override
    public List<Caracteristica> obtenerCarasteristicas() {
        //No esta el metodo obtener caracteristicas
        return null;
    }
}
