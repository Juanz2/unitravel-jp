package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {

    @Query("select c.hoteles from Ciudad c where c.nombre = ?1")
    List<Hotel>obtenerHotelesCiudad(String nombreCiudad);

    @Query("select c from Ciudad  c where c.nombre = ?1 and c.estado = 'A'")
    Ciudad obtenerCiudad(String nombreCiudad);

    @Query("select c from Ciudad  c where  c.estado = 'A'")
    List<Ciudad> obtenerCiudades();
}
