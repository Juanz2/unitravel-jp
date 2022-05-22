package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class UsuarioBean implements Serializable {

    private final UsuarioServicio usuarioServicio;
    private final UnitravelServicio unitravelServicio;

    @Getter @Setter
    private List<Ciudad> listaCiudades;
    @Getter
    @Setter
    private Usuario usuario;

    public UsuarioBean(UsuarioServicio usuarioServicio, UnitravelServicio unitravelServicio) {
        this.usuarioServicio = usuarioServicio;
        this.unitravelServicio = unitravelServicio;
    }

    @PostConstruct
    public void init() {
        listaCiudades = unitravelServicio.obtenerCiudades();
        usuario = new Usuario();
    }

    /**
     * Permite registrar el usuario en el sistema
     */
    public void registrarUsuario() {
        try {
            usuarioServicio.registrarUsuario(usuario);
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta\n", "Acción procesada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            limpiarCampos();
        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta\n", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

    /**
     *
     */
    private void limpiarCampos(){
        this.usuario = null;
    }
}
