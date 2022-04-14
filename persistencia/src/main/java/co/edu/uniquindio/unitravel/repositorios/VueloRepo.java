package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.dto.VueloDto;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepo extends JpaRepository<Vuelo, Integer> {

    @Query("select new co.edu.uniquindio.unitravel.dto.VueloDto( v.ciudadOrigen.nombre, v.ciudadDestino.nombre, v.codigo, v.estado, count(v)) from Vuelo v group by v")
    List<VueloDto> vuelosPorCiudad();
}
