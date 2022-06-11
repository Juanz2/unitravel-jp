package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class CambiarPasswordBean implements Serializable {


    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter
    @Setter
    private String password1;
    @Getter
    @Setter
    private String password2;

    @Getter @Setter
    private boolean cambiado = false;


    @Value("#{param['usuario']}")
    private String usuarioCambio;

    public void cambiarPassword() {

        if (!password1.equals(password2)) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta\n", "Las contraseñas no coinciden");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        } else {
            try {
                Usuario usuario = usuarioServicio.obtenerUsuario(usuarioCambio);
                usuario.setPassword(password1);
                usuarioServicio.actualizarUsuario(usuario);
                cambiado = true;
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta\n", "Cambio realizado con éxito");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            } catch (Exception e) {
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta\n", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msj);
            }
        }

    }

    public String mostrarLogin(){

        return   "login?faces-redirect=true";
    }


}
