package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.repositorios.HabitacionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionImpl implements HabitacionServicio {


    private final HabitacionRepo habitacionRepo;

    public HabitacionImpl(HabitacionRepo habitacionRepo) {this.habitacionRepo = habitacionRepo;}

    @Override
    public Habitacion registrarHabitacion(Habitacion habitacion){ return habitacionRepo.save(habitacion);}

    @Override
    public Habitacion actualizarHabitacion(Habitacion habitacion) { return habitacionRepo.save(habitacion);}

    @Override
    public Habitacion obtenerHabitacion(int codigo) throws Exception {
        Habitacion habitacion = habitacionRepo.findById(codigo).orElse(null);
        if(habitacion == null){
            throw new Exception("La habitación "+ codigo + "no existe");
        }
        return habitacion;
    }

    @Override
    public void eliminarVuelo(int codigo) throws Exception {
        Habitacion habitacion = habitacionRepo.findById(codigo).orElse(null);
        if(habitacion == null){
            throw new Exception("La habitacion "+ codigo + "No existe");
        }
        habitacionRepo.delete(habitacion);
    }

    @Override
    public List<Habitacion> obtenerHabitacion() { return null;}
}
