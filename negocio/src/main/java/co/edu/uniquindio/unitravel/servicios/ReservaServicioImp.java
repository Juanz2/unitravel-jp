package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServicioImp implements ReservaServicio {


    private final ReservaRepo reservaRepo;

    public ReservaServicioImp(ReservaRepo reservaRepo) {
        this.reservaRepo = reservaRepo;
    }

    @Override
    public Reserva registrarReserva(Reserva reserva) throws Exception {

        if (reserva.getFechaInicio().isAfter(reserva.getFechaFin())) {
            throw new Exception("La fecha inicio" + reserva.getFechaInicio() + " es mayor a la fecha fin " + reserva.getFechaFin());
        }
        if (reserva.getCantidadPersonas() <= 0) {
            throw new Exception("La cantidad de personas debe ser mayor a 0");
        }
        if (reserva.getPrecioTotal() <= 0) {
            throw new Exception("El precio total debe ser mayor a 0");
        }
        return reservaRepo.save(reserva);
    }

    @Override
    public Reserva actualizarReserva(Reserva reserva) throws Exception {

        if (reserva.getFechaInicio().isAfter(reserva.getFechaFin())) {
            throw new Exception("La fecha inicio" + reserva.getFechaInicio() + " es mayor a la fecha fin " + reserva.getFechaFin());
        }
        if (reserva.getCantidadPersonas() <= 0) {
            throw new Exception("La cantidad de personas debe ser mayor a 0 ");
        }
        if (reserva.getPrecioTotal() <= 0) {
            throw new Exception("El precio total debe ser mayor a 0");
        }
        return reservaRepo.save(reserva);
    }

    @Override
    public Reserva obtenerReserva(int codigo) throws Exception {
        Reserva reserva = reservaRepo.getById(codigo);
        if(reserva == null)
            throw new Exception("La reserva " + codigo +" no existe");
        return reserva;
    }

    @Override
    public void eliminarReserva(int codigo) throws Exception {
        Reserva reserva = reservaRepo.getById(codigo);
        if(reserva == null)
            throw new Exception("La reserva " + codigo +" no existe");
        reservaRepo.delete(reserva);

    }

    @Override
    public List<Reserva> obtenerReservas() {
        return reservaRepo.obtenerListaReservas();
    }
}
