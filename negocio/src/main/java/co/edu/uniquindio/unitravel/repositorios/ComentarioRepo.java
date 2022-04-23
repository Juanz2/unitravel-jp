package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.dto.ComentarioDto;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario, Integer> {

    @Query("select new co.edu.uniquindio.unitravel.dto.ComentarioDto(c.usuario.nombre, c.hotel.nombre, c.fechaCalificacion, c.calificacion, c.comentario) " +
            "from Comentario c where c.estado = 'A'")
    List<ComentarioDto> comentariosHoteles();
}
