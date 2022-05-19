package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Silla;
import co.edu.uniquindio.unitravel.servicios.SillaServicio;
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
public class SillaBean implements Serializable {

    private final SillaServicio sillaServicio;
    @Getter @Setter
    private Silla silla;
    @Getter @Setter
    private Silla sillaSeleccionada;
    @Getter @Setter
    private List<Silla> sillasSeleccionadas;

    @Getter @Setter
    private List<Silla> listaSillas;


    public SillaBean(SillaServicio sillaServicio) {
        this.sillaServicio = sillaServicio;
    }


    @PostConstruct
    public void init() {

        listaSillas = new ArrayList<>();
        listaSillas = sillaServicio.obtenerSillas();
        sillaSeleccionada = new Silla();
        sillaSeleccionada.setEstado("A");
    }

    /**
     * Realiza el registro de la silla ingresada en la interfaz
     */
    public void registrarSilla() {

        try {
            sillaServicio.registrarSilla(sillaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Acción procesada"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-silla");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-silla");
        }
    }

    /**
     * Permite eliminar la silla seleccionada
     */
    public void eliminarSilla() {
        try {
            sillaServicio.eliminarSilla(sillaSeleccionada.getCodigo());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Silla eliminada"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-silla");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-silla");
        }
    }

    /**
     * Permite actualizar la silla seleccionada
     */
    public void actualizarSilla() {

        try {
            sillaServicio.actualizarSilla(sillaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Silla actualizada"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-silla");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-silla");
        }
    }

    /**
     * Permite eliminar más de una silla
     */
    public void eliminarListaSillas(){
        for (Silla silla : sillasSeleccionadas){
            try {
                sillaServicio.eliminarSilla(silla.getCodigo());
            }catch (Exception e){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
                PrimeFaces.current().ajax().update("form:messages", "form:dt-silla");
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sillas eliminadas con éxito"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-silla");
    }

    /**
     *
     */
    public void openNew(){
        silla = new Silla();
    }

}
