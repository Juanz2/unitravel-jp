package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.dto.VueloDto;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepo extends JpaRepository<Vuelo, Integer> {

    @Query("select v.ciudad.nombre, v.codigo, v.estado from Vuelo v")
    VueloDto vuelosCiudad();
}
