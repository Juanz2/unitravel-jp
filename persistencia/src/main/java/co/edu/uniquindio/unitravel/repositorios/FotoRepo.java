package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoRepo extends JpaRepository<Foto, Integer> {

    @Query("select f from Foto f where f.estado = 'A'")
    List<Foto>obtenerFotos ();
}
