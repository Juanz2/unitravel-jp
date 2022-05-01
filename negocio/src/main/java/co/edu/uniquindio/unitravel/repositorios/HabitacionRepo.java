package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HabitacionRepo extends JpaRepository<Habitacion, Integer> {

    @Query("select c from Caracteristica c join c.habitaciones hb where hb.codigo = ?1")
    List<Caracteristica> obtenerCaracteristicasHabitacion(int codigoHabitacion);
    @Query("select h from Habitacion h where h.estado = 'A'")
    List<Habitacion> obtenerListaHabitaciones();

    @Query("select res.habitaciones from Reserva res join res.habitaciones where :fechaInicioReserva " +
            "not between  res.fechaInicio and res.fechaFin and res.estado = 'A'" )
    List<Habitacion> obtenerHabitacionesDisponibles(LocalDateTime fechaInicioReserva);
}
