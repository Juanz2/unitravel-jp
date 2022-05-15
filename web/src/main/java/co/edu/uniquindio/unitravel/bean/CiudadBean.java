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

        ciudadSeleccionada = new Ciudad();
        ciudadSeleccionada.setEstado("A");
    }

    /**
     *
     */
    public void registrarCiudad() {

        try {
            ciudadServicio.registrarCiudad(ciudadSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Acción procesada"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-ciudad");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-ciudad");
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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-ciudad");
        }
    }

    public void openNew(){
        ciudadSeleccionada = new Ciudad();
        ciudadSeleccionada.setEstado("A");
    }
}
