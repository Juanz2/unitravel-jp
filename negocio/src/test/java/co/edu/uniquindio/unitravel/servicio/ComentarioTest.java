package co.edu.uniquindio.unitravel.servicio;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.ComentarioServicio;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

public class ComentarioTest {

    @Autowired
    private ComentarioServicio comentarioServicio;
    @Autowired
    private HotelServicio hotelServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarComentario() {

        try {
            Hotel hotel = hotelServicio.obtenerHotel(1);
            Usuario usuario = usuarioServicio.obtenerUsuario("1094975931");
            Comentario comentario = new Comentario("Excelente Hotel :)", 5, "A", hotel, usuario);
            comentarioServicio.registrarComentario(comentario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarComentario() {

        try {
            Comentario comentario = comentarioServicio.obtenerComentario(1);
            comentario.setComentario("Pesimo servicio");
            comentario.setCalificacion(2);
            comentarioServicio.actualizarComentario(comentario);

        } catch (Exception e) {
            Assertions.assertTrue(false);
            System.out.println(e.getMessage());
        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarComentario(){
        try {
            comentarioServicio.eliminarComentario(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
            System.out.println(e.getMessage());
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentarios(){
        List<Comentario> listarComentarios = comentarioServicio.obtenerComentarios();
        listarComentarios.forEach(System.out::println);
    }
}


