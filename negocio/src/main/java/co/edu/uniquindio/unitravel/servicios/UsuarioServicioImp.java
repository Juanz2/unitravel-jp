package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImp implements UsuarioServicio {


    private final UsuarioRepo usuarioRepo;

    public UsuarioServicioImp (UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception{
        Usuario usuarioBuscado = obtenerUsuario(u.getCedula());
        if(usuarioBuscado!=null){
            throw new Exception("El usuario "+u.getCedula()+" ya se encuentra registrado");
        }
        if(buscarPorCorreo(u.getEmail()) !=null){
            throw new Exception("El usuario "+u.getCedula()+" ya se encuentra registrado");
        }
      return  usuarioRepo.save(u);
    }

    /**
     * Permite buscar un usuario por correo electrónico
     * @param correo
     * @return Usuario si el correo existe
     */
    public Usuario buscarPorCorreo(String correo){
        return usuarioRepo.findByEmail(correo).orElse(null);
    }

    @Override
    public Usuario actualizarUsuario(Usuario u) {
        return  usuarioRepo.save(u);
    }

    @Override
    public Usuario obtenerUsuario(String cedula) {
        return usuarioRepo.findById(cedula).orElse(null);
    }

    @Override
    public void eliminarUsuario(String cedula) throws Exception{
        Usuario usuario = obtenerUsuario(cedula);
        if (usuario!=null){
            usuarioRepo.delete(usuario);
        }else {
            throw new Exception("El usuario " + cedula + " No existe");
        }
    }

    @Override
    public List<Usuario> listarUsuarios() throws Exception{
       return usuarioRepo.findAll();
    }

    @Override
    public Usuario validarLogin(String correo, String password) throws Exception {
        Usuario usuario = usuarioRepo.usuarioIngreso(correo, password);
        if (usuario==null){
            throw  new Exception("Datos autenticación incorrectos");
        }
        return  usuario;
    }
}
