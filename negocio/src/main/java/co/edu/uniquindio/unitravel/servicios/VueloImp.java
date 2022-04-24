package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.repositorios.VueloRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloImp implements VueloServicio{


    private final VueloRepo vueloRepo;

    public VueloImp (VueloRepo vueloRepo){
        this.vueloRepo = vueloRepo;
    }

    @Override
    public Vuelo registrarVuelo(Vuelo vuelo) {return vueloRepo.save(vuelo);}

    @Override
    public Vuelo actualizarVuelo(Vuelo vuelo) {return vueloRepo.save(vuelo);}

    @Override
    public Vuelo obtenerVuelo(int codigo) throws Exception {
        Vuelo vuelo = vueloRepo.findById(codigo).orElse(null);
        if(vuelo == null){
            throw new Exception("El vuelo "+ codigo+ " no existe");
        }
        return vuelo;
    }

    @Override
    public void eliminarVuelo(int codigo) throws Exception {
        Vuelo vuelo = vueloRepo.findById(codigo).orElse(null);
        if(vuelo == null){
            throw new Exception("El vuelo "+ codigo+ " no existe");
        }
        vueloRepo.delete(vuelo);
    }

    @Override
    public List<Vuelo> obtenerVuelos() {
        return vueloRepo.obtenerVuelos();
    }
}
