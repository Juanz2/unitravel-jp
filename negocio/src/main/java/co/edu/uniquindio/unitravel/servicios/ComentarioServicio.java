package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Comentario;

import java.util.List;

public interface ComentarioServicio {

    Comentario registrarComentario(Comentario comentario) throws Exception;
    Comentario actualizarComentario(Comentario comentario);
    Comentario obtenerComentario(int codigo) throws Exception;
    void eliminarComentario (int codigo) throws Exception;

    List<Comentario> obtenerComentarios ();

}
