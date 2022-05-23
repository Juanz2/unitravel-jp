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

public class HabitacionBean {

    private final HabitacionServicio habitacionServicio;
    private final HotelServicio hotelServicio;
    @Getter @Setter
    private List<Hotel> listaHoteles;
    @Getter @Setter
    private List<Habitacion> listaHabitaciones;
    @Getter @Setter
    private Habitacion habitacion;

    @Getter @Setter
    private Habitacion habitacionSeleccionada;

    @Getter @Setter
    private List<Habitacion> habitacionesSeleccionadas;

    public HabitacionBean(HabitacionServicio habitacionServicio, HotelServicio hotelServicio) {
        this.habitacionServicio = habitacionServicio;
        this.hotelServicio = hotelServicio;
    }

    @PostConstruct
    public void init (){
        habitacionSeleccionada = new Habitacion();
        habitacionSeleccionada.setEstado("A");
        listaHabitaciones = habitacionServicio.obtenerHabitaciones();
        listaHoteles = hotelServicio.obtenerHoteles();
    }

    /**
     * Registra la habitación ingresada por el usuario
     */
    public void registrarHabitacion(){
        try {
            habitacionServicio.registrarHabitacion(habitacionSeleccionada);
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
