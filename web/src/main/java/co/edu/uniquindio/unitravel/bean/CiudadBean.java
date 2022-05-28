package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.servicios.CiudadServicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.IOUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
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

    @Value("${upload.url}")
    private String urlImagenes;

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
            listaCiudades = ciudadServicio.listarCiudades();
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

    /**
     * @param event evento
     */
    public void subirImagenes(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if (nombreImagen != null) {
            ciudadSeleccionada.setFoto(nombreImagen);
        }
    }

    /**
     * @param imagen imagen
     * @return nombre de archivo
     */
    public String subirImagen(UploadedFile imagen) {
        File archivo = new File(urlImagenes + "/" + imagen.getFileName());
        try {
            OutputStream outputStream = new FileOutputStream(archivo);
            IOUtils.copy(imagen.getInputStream(), outputStream);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return imagen.getFileName();
    }
}
