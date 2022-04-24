package co.edu.uniquindio.unitravel.servicio;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearUsuario() {

        Usuario usuario = new Usuario("1094975931", "Juan Pablo", "jpzh@gmail.com", "123@93733");
        try {
            Usuario usuarioGuardado = usuarioServicio.registrarUsuario(usuario);
            Assertions.assertNotNull(usuarioGuardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUsuario() {
        Usuario usuario;
        try {
            usuario = usuarioServicio.obtenerUsuario("1094975931");
            usuario.setCedula("109478263");
            usuario.setNombre("Manolo");
            usuario.setEmail("jpzabalah@uqvirtual.edu.co");
            Usuario usuarioModificado = usuarioServicio.actualizarUsuario(usuario);
            Assertions.assertEquals("jpzabalah@uqvirtual.edu.co", usuarioModificado.getEmail());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarUsuario() {

        try {
            usuarioServicio.eliminarUsuario("1094975931");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuarios() {
        List<Usuario> listaUsuarios;
        try {
            listaUsuarios = usuarioServicio.listarUsuarios();
            Assertions.assertEquals(5, listaUsuarios.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}









