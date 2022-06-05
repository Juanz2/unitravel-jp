package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
@ViewScoped
public class DetalleHotelBean implements Serializable {


    @Autowired
    private HotelServicio hotelServicio;

    @Autowired
    private MetodoPagoServicio metodoPagoServicio;

    @Autowired
    private ReservaServicio reservaServicio;

    @Autowired
    private ComentarioServicio comentarioServicio;

    @Autowired
    private HabitacionServicio habitacionServicio;

    @Value("#{param['hotelId']}")
    private String parametroBusqueda;

    @Getter
    @Setter
    private List<MetodoPago> metodosPago;

    @Getter
    @Setter
    private Hotel hotel;

    @Getter
    @Setter
    private Reserva reserva;

    @Getter
    @Setter
    private Comentario comentario;

    @Getter
    @Setter
    private Habitacion habitacionReserva;

    @Value(value = "#{seguridadBean.usuario}")
    private Usuario usuarioSesion;

    @Getter
    @Setter
    private List<Comentario> comentariosHotel;

    private List<Habitacion> habitaciones;

    @PostConstruct
    public void init() {
        comentario = new Comentario();
        reserva = new Reserva();
        habitaciones = new ArrayList<>();

        if (parametroBusqueda != null) {
            try {
                hotel = hotelServicio.obtenerHotel(Integer.parseInt(parametroBusqueda));
                comentariosHotel = comentarioServicio.obtenerComentariosHotel(hotel.getCodigo());
                metodosPago = metodoPagoServicio.obtenerMetodosPago();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }


    /**
     * Permite registrar el comentario al hotel
     */
    public void registrarComentario() {

        try {
            Hotel hotelComentario = hotelServicio.obtenerHotel(Integer.parseInt(parametroBusqueda));
            comentario.setHotel(hotelComentario);
            comentario.setUsuario(usuarioSesion);
            comentario.setEstado("A");
            comentario.setFechaCalificacion(LocalDateTime.now());
            comentarioServicio.registrarComentario(comentario);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Procesado correctamente");
            FacesContext.getCurrentInstance().addMessage("comentario-bean", fm);
        } catch (Exception e) {
            e.getStackTrace();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("comentario-bean", fm);
        }
    }

    public void registrarReserva() {


        try {
            reserva.setHabitaciones(habitaciones);
            double valorTotal = calcularValorTotal(habitaciones.get(0));
            reserva.setEstado("A");
            reserva.setPrecioTotal(valorTotal);
            reserva.setUsuario(usuarioSesion);
            reserva.setEstadoReserva("Reservado");
            reserva.setFechaReserva(LocalDateTime.now());
            reservaServicio.registrarReserva(reserva);

            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Procesado correctamente");
            FacesContext.getCurrentInstance().addMessage("reserva-bean", fm);

        } catch (Exception e) {
            e.getStackTrace();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta reserva :(", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("reserva-bean", fm);
        }

    }

    /**
     * Obtiene fecha de comentario en formato yyyy-MM-dd HH:mm:ss
     *
     * @param comentario
     * @return
     */
    public String obtenerFechaComentario(Comentario comentario) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return comentario.getFechaCalificacion().format(formato);
    }

    /**
     * Convierte la fecha en Date a LocalDateTime
     *
     * @param date
     * @return Fecha LocalDateTime
     */
    public LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    /**
     * Inicializa la variable según la habitacion seleccionada
     *
     * @param idHabitacion
     */
    public void inicializarHabitacionReserva(int idHabitacion) {
        System.out.println(idHabitacion);
        try {
            Habitacion habitacion = habitacionServicio.obtenerHabitacion(idHabitacion);
            habitaciones.add(habitacion);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /**
     *
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    private long obtenerCantidadDias(LocalDateTime fechaInicio, LocalDateTime fechaFin) {

        return DAYS.between(fechaInicio, fechaFin);
    }

    /**
     * Calcula el valor totol del la reserva
     * @param habitacion
     * @return
     */
    private double calcularValorTotal(Habitacion habitacion) {

        double valorTotal = 0.0;
        long cantidadDias = obtenerCantidadDias(reserva.getFechaInicio(), reserva.getFechaFin());
        valorTotal = cantidadDias * habitacion.getPrecio();

        return valorTotal;
    }

}
