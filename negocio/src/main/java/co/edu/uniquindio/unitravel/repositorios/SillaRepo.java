package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Silla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SillaRepo extends JpaRepository<Silla, Integer> {

    /*
        Se obtiene la lista de sillas disponibles por el vuelo seleccionado
     */
    @Query("select s from Silla s where s.vuelo.codigo = ?1 and s.estadoSilla = 'Disponible' " +
            "and s.estado = 'A' order by s.posicion asc")
    List<Silla> obtenerSillasDisponiblesVuelo(int codigoVuelo);

    /*
        Se obtienen las sillas ordenadas por precio
     */
    @Query("select s from Silla s where s.estado = 'A' order by s.precio asc")
    List<Silla> obtenerSillasOrdenPrecio();

    @Query(value = "select * from Silla s where s.estado = 'A' and s.estado_silla='Disponible' limit 1", nativeQuery = true)
    Silla obtenerSillaAleatoria();

    @Query("select s from Silla s where s.estado = 'A'")
    List<Silla> obtenerListaSillas();
}
