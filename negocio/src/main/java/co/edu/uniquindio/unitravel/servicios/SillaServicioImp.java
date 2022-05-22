package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Silla;
import co.edu.uniquindio.unitravel.repositorios.SillaRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SillaServicioImp implements SillaServicio{

    private final SillaRepo sillaRepo;

    public SillaServicioImp(SillaRepo sillaRepo) {this.sillaRepo = sillaRepo;}

    @Override
    public Silla registrarSilla(Silla silla) throws Exception {
        if (silla.getPrecio() <=0){
            throw new Exception("El valor de la silla debe ser mayor a 0");
        }
        return sillaRepo.save(silla);
    }

    @Override
    public Silla actualizarSilla(@NotNull Silla silla) throws Exception{
        if(silla.getPrecio() <=0)
            throw new Exception("El precio de la silla debe ser mayor a 0");
        return sillaRepo.save(silla);
    }

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
    public List<Silla> listarSillas() {
        return null;
    }

    @Override
    public List<Silla> obtenerSillas() {
        return sillaRepo.obtenerListaSillas();
    }

    @Override
    public Silla obtenerSillaAleatoria(){
        return sillaRepo.obtenerSillaAleatoria();
    }

}
