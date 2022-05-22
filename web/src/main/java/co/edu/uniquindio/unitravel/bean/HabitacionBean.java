package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.HabitacionServicio;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
@Getter
@Setter
public class HabitacionBean {

    private final HabitacionServicio habitacionServicio;
    private final HotelServicio hotelServicio;
    private List<Hotel> listaHoteles;
    private List<Habitacion> listaHabitaciones;
    private Habitacion habitacion;

    private Habitacion habitacionSeleccionada;


    public HabitacionBean(HabitacionServicio habitacionServicio, HotelServicio hotelServicio) {
        this.habitacionServicio = habitacionServicio;
        this.hotelServicio = hotelServicio;
    }

    @PostConstruct
    public void init (){
        listaHabitaciones = habitacionServicio.obtenerHabitaciones();
        listaHoteles = hotelServicio.obtenerHoteles();
    }

    /**
     * Registra la habitación ingresada por el usuario
     */
    public void registrarHabitacion(){
        try {
            habitacionServicio.registrarHabitacion(habitacion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Acción procesada"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-habitacion");
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-habitacion");
        }
    }

    /**
     * Elimina la ciudad seleccionada
     */
    public void eliminarHabitacion(){
        try {
            habitacionServicio.eliminarHabitacion(habitacion.getCodigo());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Acción procesada"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-habitacion");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-habitacion");
        }
    }

    public void openNew(){
        habitacion = new Habitacion();
    }

}
