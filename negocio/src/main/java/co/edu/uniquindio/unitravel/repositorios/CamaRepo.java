package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Cama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CamaRepo extends JpaRepository<Cama, Integer> {


    @Query("select c from Cama c where c.estado = 'A'")
    List<Cama> obtenerListaCamas();

    @Query("select c from Cama c join Habitacion hb where hb.codigo = ?1")
    List<Cama> obtenerCamaHabitacion(Integer idHabitacion);
}
