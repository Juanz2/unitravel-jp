package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;
    Usuario actualizarUsuario(Usuario u) throws Exception;
    Usuario obtenerUsuario(String cedula) throws Exception;
    void eliminarUsuario(String cedula) throws Exception;
    List<Usuario> listarUsuarios() throws Exception;
    Usuario validarLogin(String correo, String password) throws Exception;

    void recuperarPassword(String correo) throws  Exception;
}
