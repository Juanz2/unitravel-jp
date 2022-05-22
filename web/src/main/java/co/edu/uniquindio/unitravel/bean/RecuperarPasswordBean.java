package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class RecuperarPasswordBean {

    @Getter @Setter
    private String correo;

    private final UsuarioServicio usuarioServicio;

    public RecuperarPasswordBean(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }


    /**
     *
     */
    public void recuperarPassword(){
        try{
            usuarioServicio.recuperarPassword(this.correo);
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta\n", "Acción procesada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }catch (Exception e){
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta\n", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }

    }
}
