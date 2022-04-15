package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {
        Usuario usuario = new Usuario("1094975931", "Juan Pablo", "jpzh@gmail.com", "123@93733");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        Assertions.assertNotNull(usuarioGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {
        Usuario usuario = new Usuario("1094975931", "Juan Pablo", "jpzh@gmail.com", "123@93733");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioRepo.delete(usuarioGuardado);

        Usuario usuarioBuscado = usuarioRepo.findById("1094975931").orElse(null);
        Assertions.assertNull(usuarioBuscado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {
        Usuario usuario = new Usuario("1094975931", "Juan Pablo", "jpzh@gmail.com", "123@93733");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        usuarioGuardado.setPassword("287363/2**");
        usuarioRepo.save(usuarioGuardado);
        Usuario usuarioBuscado = usuarioRepo.findById("1094975931").orElse(null);
        if (usuarioBuscado != null) {
            Assertions.assertEquals("287363/2**", usuarioBuscado.getPassword());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<Usuario> usuarios = usuarioRepo.findAll();
        System.out.println("Lista:\n" + usuarios);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void validarIngresoUsuario() {

        Usuario usuario = usuarioRepo.usuarioIngreso("jpzh351@gmail.com", "passw0rd123*");
        boolean ingreso = usuario != null;
        Assertions.assertTrue(ingreso);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void validarUsuarioCrear() {

        Usuario usuario = usuarioRepo.validarUsuarioCrear("jpzh351@gmail.com", "1094874931");
        boolean existe = usuario != null;
        Assertions.assertTrue(existe);
    }
}
