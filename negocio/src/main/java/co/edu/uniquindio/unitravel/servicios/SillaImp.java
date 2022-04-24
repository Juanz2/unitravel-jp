package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Silla;
import co.edu.uniquindio.unitravel.repositorios.SillaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SillaImp implements SillaServicio{

    private final SillaRepo sillaRepo;

    public SillaImp(SillaRepo sillaRepo) {this.sillaRepo = sillaRepo;}

    @Override
    public Silla registrarSilla(Silla silla) throws Exception {return sillaRepo.save(silla);}

    @Override
    public Silla actualizarSilla(Silla silla) {return sillaRepo.save(silla);}

    @Override
    public Silla obtenerSilla(int codigo) throws Exception {
        Silla silla = sillaRepo.findById(codigo).orElse(null);
        if(silla == null){
            throw new Exception("la silla"+ codigo + "no existe");
        }
        return silla;
    }

    @Override
    public void eliminarSilla(int codigo) throws Exception {
        Silla silla = sillaRepo.findById(codigo). orElse(null);
        if(silla == null){
            throw  new Exception("La silla "+ codigo + "no existe");
        }
        sillaRepo.delete(silla);
    }

    @Override
    public List<Silla> obtenerSillas() {return sillaRepo.obtenerSillasOrdenPrecio();}
}
