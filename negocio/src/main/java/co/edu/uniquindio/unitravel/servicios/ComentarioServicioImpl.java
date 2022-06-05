package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.repositorios.ComentarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;

    public ComentarioServicioImpl(ComentarioRepo comentarioRepo) {
        this.comentarioRepo = comentarioRepo;
    }


    @Override
    public Comentario registrarComentario(Comentario comentario) {
        return comentarioRepo.save(comentario);
    }

    @Override
    public Comentario actualizarComentario(Comentario comentario) {
        return comentarioRepo.save(comentario);
    }

    @Override
    public Comentario obtenerComentario(int codigo) throws Exception {
        Comentario comentario = comentarioRepo.findById(codigo).orElse(null);
        if (comentario == null) {
            throw new Exception("El comentario" + codigo + "no existe");
        }
        return comentario;
    }

    @Override
    public void eliminarComentario(int codigo) throws Exception {
        Comentario comentario = comentarioRepo.findById(codigo).orElse(null);
        if (comentario == null) {
            throw new Exception("El vuelo " + codigo + " no existe");
        }
        comentarioRepo.delete(comentario);
    }

    @Override
    public List<Comentario> obtenerComentarios() {
        return comentarioRepo.obtenerComentarios();
    }

    @Override
    public List<Comentario> obtenerComentariosHotel(Integer idHotel) {
        return comentarioRepo.obtenerComentariosHotel(idHotel);
    }

}
