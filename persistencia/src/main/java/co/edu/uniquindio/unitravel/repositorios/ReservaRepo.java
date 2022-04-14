package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer> {

    /*
    Cree una consulta que permita determinar el número de reservas que tiene un hotel específico cuya
    fecha de inicio de reserva aún no haya pasado.
     */
    @Query("select count(r) from Reserva  r join r.habitaciones hb where hb.hotel.codigo = ?1 " +
            "and r.fechaInicio > current_date")
    int numeroReservasHotel(int codigoHotel);

    /*
    Cree una consulta que calcule el valor total que ha gastado un usuario en reservas. Total por
    reserva o total por todas las reservas.
     */
    @Query("select sum(res.precioTotal) from Reserva res where res.usuario.cedula = ?1")
    double calcularReservasTotalUsuario(String cedulaUsuario);

    /*
    Cree una consulta que devuelva una lista de reservas y el detalle de cada reserva de un cliente
    dado su código.
     */
    @Query("select res from Reserva res where res.usuario.cedula = ?1")
    List<Reserva>listaReservasUsuario(String cedula);
}
