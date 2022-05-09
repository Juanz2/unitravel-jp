package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.servicios.CiudadServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class CiudadBean implements Serializable {

    private final CiudadServicio ciudadServicio;
    @Getter
    @Setter
    private Ciudad ciudad;
    public CiudadBean(CiudadServicio ciudadServicio) {
        this.ciudadServicio = ciudadServicio;
    }

    @PostConstruct
    public void init() {
        ciudad = new Ciudad();
        ciudad.setEstado("A");
    }

    /**
     *
     */
    public void registrarCiudad(){
        try {
            ciudadServicio.registrarCiudad(ciudad);
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta\n", "Acción procesada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta\n", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }



}
