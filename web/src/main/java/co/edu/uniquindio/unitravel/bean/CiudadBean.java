package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.servicios.CiudadServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Getter
@Setter
public class CiudadBean implements Serializable {

    private final CiudadServicio ciudadServicio;

    private Ciudad ciudad;

    private List<Ciudad> ciudadesSeleccionadas;

    private List<Ciudad> listaCiudades;

    private Ciudad ciudadSeleccionada;

    public CiudadBean(CiudadServicio ciudadServicio) {
        this.ciudadServicio = ciudadServicio;
    }

    @PostConstruct
    public void init() {

        this.listaCiudades = new ArrayList<>();
        this.listaCiudades = ciudadServicio.listarCiudades();
    }

    /**
     *
     */
    public void registrarCiudad() {
        try {
            ciudadServicio.registrarCiudad(ciudad);
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta\n", "Acción procesada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta\n", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }


    /**
     * Permite eliminar la ciudad seleccionada
     */
    public void eliminarCiudad() {
        try {
            ciudadServicio.eliminarCiudad(this.ciudadSeleccionada.getCodigo());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ciudad removida"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-ciudad");
            this.ciudadSeleccionada = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se ha logrado eliminar la ciudad"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-ciudad");
        }
    }

    public void openNew(){
        this.ciudadSeleccionada = new Ciudad();
    }
}
