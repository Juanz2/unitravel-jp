package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {

    /*
        Verifica el acceso al sistema con usuario y contraseña
     */
    @Query("select u from Usuario  u where u.email = ?1 and u.password = ?2")
    Usuario usuarioIngreso(String correo, String password);

    @Query("select u from Usuario u where u.email = ?1 or u.cedula = ?2")
    Usuario validarUsuarioCrear(String email, String cedula);

    Optional<Usuario> findByEmail(String correo);
}
