package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.CaracteristicaServicio;
import co.edu.uniquindio.unitravel.servicios.HabitacionServicio;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
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
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class HotelBean implements Serializable {

    private final HotelServicio hotelServicio;
    private final HabitacionServicio habitacionServicio;
    private final UnitravelServicio unitravelServicio;
    private final CaracteristicaServicio caracteristicaServicio;
    private List<Ciudad> listaCiudades;

    @Getter
    @Setter
    private List<Caracteristica> listaCaracteristicaHotel;

    @Getter
    @Setter
    private List<Caracteristica> listaCaracteristicaHabitacion;

    @Getter
    @Setter
    private Hotel hotel;

    @Getter
    @Setter
    private Habitacion habitacion;

    @Value("${upload.url}")
    private String urlImagenes;
    @Getter
    @Setter
    private Hotel hotelSeleccionado;

    @Getter
    @Setter
    private ArrayList<String> imagenes;

    @Getter
    @Setter
    private List<Hotel> listaHoteles;

    @Getter
    @Setter
    private List<Hotel> hotelesSeleccionados;

    @Getter
    @Setter
    private List<Caracteristica> caracteristicasHotel;

    @Getter
    @Setter
    private List<Caracteristica> caracteristicasHabitacion;

    /**
     * @param hotelServicio
     * @param unitravelServicio
     * @param habitacionServicio
     */
    public HotelBean(HotelServicio hotelServicio, UnitravelServicio unitravelServicio, HabitacionServicio habitacionServicio, CaracteristicaServicio caracteristicaServicio) {
        this.hotelServicio = hotelServicio;
        this.unitravelServicio = unitravelServicio;
        this.habitacionServicio = habitacionServicio;
        this.caracteristicaServicio = caracteristicaServicio;
    }

    @PostConstruct
    public void init() {
        listaHoteles = hotelServicio.obtenerHoteles();
        listaCiudades = unitravelServicio.obtenerCiudades();
        listaCaracteristicaHotel = caracteristicaServicio.obtenerCaracteristicasHoteles();
        listaCaracteristicaHabitacion = caracteristicaServicio.obtenerCaracteristicasHabitaciones();
        hotelSeleccionado = new Hotel();
        hotelSeleccionado.setEstado("A");
        this.imagenes = new ArrayList<>();
        this.caracteristicasHotel = new ArrayList<>();
        this.habitacion = new Habitacion();
        this.habitacion.setEstado("A");
    }

    /**
     * Permite hacer el registro del hotel -> imagen obligatoria
     */
    public void registrarHotel() {
        try {
            if (imagenes.size() > 0) {
                hotelSeleccionado.setFotos(imagenes);
                hotelSeleccionado.setCaracteristicas(caracteristicasHotel);
                hotelServicio.registrarHotel(hotelSeleccionado);
                listaHoteles = hotelServicio.obtenerHoteles();
                imagenes.clear();
                hotelSeleccionado = null;
                addMessage(FacesMessage.SEVERITY_INFO, "Información", "Acción procesada");
            } else {
                addMessage(FacesMessage.SEVERITY_ERROR, "Info Message", "Se debe registrar una imagen");
            }
        } catch (Exception e) {
            e.getStackTrace();
            addMessage(FacesMessage.SEVERITY_ERROR, "Info Message", e.getMessage());
        }
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


    /**
     * Registra la habitación ingresada por el usuario
     */
    public void registrarHabitacion() {
        try {
            if (imagenes.size() > 0) {
                habitacion.setFotos(imagenes);
                habitacion.setHotel(hotelSeleccionado);
                habitacion.setCaracteristicas(caracteristicasHabitacion);
                habitacionServicio.registrarHabitacion(habitacion);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe agregar al menos una imagen"));
                PrimeFaces.current().ajax().update("form:messages");
                imagenes.clear();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe agregar al menos una imagen"));
                PrimeFaces.current().ajax().update("form:messages");
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            PrimeFaces.current().ajax().update("form:messages");
        }
    }

    /**
     * Permite realizar la eliminación del hotel seleccionado
     */
    public void eliminarHotel() {
        try {
            hotelServicio.eliminarHotel(hotelSeleccionado.getCodigo());
            listaHoteles.remove(hotelSeleccionado);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void seleccionarHotel(Hotel h) {
        this.hotelSeleccionado = h;
        this.caracteristicasHotel = hotelServicio.obtenerCaracteristicasHotel(h.getCodigo());
        //System.out.println(caracteristicasHotel);
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
