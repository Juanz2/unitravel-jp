package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImp implements UsuarioServicio {

    private final EmailServicio emailServicio;
    private final UsuarioRepo usuarioRepo;

    public UsuarioServicioImp(UsuarioRepo usuarioRepo, EmailServicio emailServicio) {
        this.usuarioRepo = usuarioRepo;
        this.emailServicio = emailServicio;
    }

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {
        Usuario usuarioBuscado = usuarioRepo.findById(u.getCedula()).orElse(null);
        if (usuarioBuscado != null) {
            throw new Exception("El usuario " + u.getCedula() + " ya se encuentra registrado");
        }
        if (buscarPorCorreo(u.getEmail()) != null) {
            throw new Exception("El correo " + u.getEmail() + " ya se encuentra registrado");
        }
        return usuarioRepo.save(u);
    }

    /**
     * Permite buscar un usuario por correo electrónico
     *
     * @param correo correo electrónico del usuario
     * @return Usuario si el correo existe
     */
    public Usuario buscarPorCorreo(String correo) {
        return usuarioRepo.findByEmail(correo).orElse(null);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {

        Usuario usuarioBuscado = obtenerUsuario(usuario.getCedula());
        if (usuarioBuscado != null)
            throw new Exception("El usuario " + usuario.getCedula() + " ya se encuentra registrado ");
        if (buscarPorCorreo(usuario.getEmail()) != null)
            throw new Exception("El usuario " + usuario.getCedula() + " ya se encuentra registrado");
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(String cedula) throws Exception {
        Usuario usuario = usuarioRepo.findById(cedula).orElse(null);
        if (usuario == null)
            throw new Exception("El usuario " + cedula + " no existe");
        return usuario;
    }

    @Override
    public void eliminarUsuario(String cedula) throws Exception {
        Usuario usuario = obtenerUsuario(cedula);
        if (usuario != null) {
            usuarioRepo.delete(usuario);
        } else {
            throw new Exception("El usuario " + cedula + " No existe");
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario validarLogin(String correo, String password) throws Exception {
        Usuario usuario = usuarioRepo.usuarioIngreso(correo, password);
        if (usuario == null) {
            throw new Exception("Datos autenticación incorrectos");
        }
        return usuario;
    }

    @Override
    public void recuperarPassword(String correo) throws Exception {
        Usuario usuario = usuarioRepo.findByEmail(correo).orElse(null);
        if (usuario == null)
            throw new Exception("Correo electrónico no encontrado");

        emailServicio.EnviarEmail("Recuperación de contraseña", "Su contraseña es: " + usuario.getPassword(),correo);
    }
}
