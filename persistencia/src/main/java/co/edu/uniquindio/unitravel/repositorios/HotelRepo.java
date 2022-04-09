package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

    @Query("select h from Hotel h where h.numeroEstrellas = ?1")
    List<Hotel> obtenerHotelCategoria(int numeroEstrellas);

    @Query("select h.ciudad.nombre from Hotel h where  h.codigo = ?1")
    String obtenerNombreCiudad(Integer codigo);

    @Query("select h from Hotel h where h.ciudad.nombre = ?1")
    List<Hotel>obtenerHoteles(String nombreCiudad);
}
