package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer> {

    @Query("select count(r) from Reserva  r join r.habitaciones hb where hb.hotel.codigo = ?1 " +
            "and r.fechaInicio > current_date")
    int numeroReservasHotel(int codigoHotel);
}
