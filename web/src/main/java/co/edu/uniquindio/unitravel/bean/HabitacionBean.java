package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.CamaServicio;
import co.edu.uniquindio.unitravel.servicios.CaracteristicaServicio;
import co.edu.uniquindio.unitravel.servicios.HabitacionServicio;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.IOUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped

public class HabitacionBean {

    private final HabitacionServicio habitacionServicio;
    private final HotelServicio hotelServicio;

    private final CamaServicio camaServicio;
    @Getter
    @Setter
    private List<Hotel> listaHoteles;
    @Getter
    @Setter
    private List<Habitacion> listaHabitaciones;
    @Getter
    @Setter
    private Habitacion habitacion;

    @Getter
    @Setter
    private Habitacion habitacionSeleccionada;

    @Getter
    @Setter
    private List<Habitacion> habitacionesSeleccionadas;

    @Value("${upload.url}")
    private String urlImagenes;
    private final CaracteristicaServicio caracteristicaServicio;

    @Getter
    @Setter
    private ArrayList<String> imagenes;

    @Getter
    @Setter
    private List<Caracteristica> caracteristicas;

    @Getter
    @Setter
    private List<Cama> camas;

    public HabitacionBean(HabitacionServicio habitacionServicio, HotelServicio hotelServicio,
                          CaracteristicaServicio caracteristicaServicio, CamaServicio camaServicio) {
        this.habitacionServicio = habitacionServicio;
        this.hotelServicio = hotelServicio;
        this.caracteristicaServicio = caracteristicaServicio;
        this.camaServicio = camaServicio;
    }

    @PostConstruct
    public void init() {
        habitacionSeleccionada = new Habitacion();
        habitacionSeleccionada.setEstado("A");
        listaHabitaciones = habitacionServicio.obtenerHabitaciones();
        camas = camaServicio.obtenerListaCamas();
        listaHoteles = hotelServicio.obtenerHoteles();
        caracteristicas = caracteristicaServicio.obtenerCaracteristicasHabitaciones();
    }

    /**
     * Registra la habitaci??n ingresada por el usuario
     */
    public void registrarHabitacion() {
        try {
            habitacionSeleccionada.setFotos(imagenes);
            habitacionServicio.registrarHabitacion(habitacionSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Acci??n procesada"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-habitacion");
            listaHabitaciones = habitacionServicio.obtenerHabitaciones();
            habitacionSeleccionada = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-habitacion");
        }
    }

    /**
     * Elimina la ciudad seleccionada
     */
    public void eliminarHabitacion() {
        try {
            habitacionServicio.eliminarHabitacion(habitacion.getCodigo());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Acci??n procesada"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-habitacion");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-habitacion");
        }
    }

    public void openNew() {
        habitacionSeleccionada = new Habitacion();
    }

    /**
     * @param event evento
     */
    public void subirImagenes(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if (nombreImagen != null) {
            imagenes.add(nombreImagen);
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
