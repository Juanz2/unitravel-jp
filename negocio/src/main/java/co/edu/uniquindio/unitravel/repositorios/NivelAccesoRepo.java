package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.NivelAcceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NivelAccesoRepo extends JpaRepository<NivelAcceso, Integer> {

    @Query("select nv from NivelAcceso  nv where nv.nombre = ?1 and nv.estado = 'A'")
    NivelAcceso obtenerNivelAccesoPorNombre (String nombre);

    @Query("select  nv from NivelAcceso nv where  nv.estado = 'A'")
    List<NivelAcceso> obtenerListaNivelesAcceso();

}
