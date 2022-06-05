package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.ReservaServicio;
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
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Component
@ViewScoped
public class ReservasUsuarioBean implements Serializable {

    @Autowired
    private ReservaServicio reservaServicio;

    @Getter
    @Setter
    private List<Reserva> listaReservas;

    @Value(value = "#{seguridadBean.usuario}")
    private Usuario usuarioSesion;

    @Getter
    @Setter
    private Reserva reserva;

    @Getter
    @Setter
    private Reserva reservaSeleccionada;


    @PostConstruct
    public void init() {
        reservaSeleccionada = new Reserva();
        try {
            listaReservas = reservaServicio.listarReservasUsuario(usuarioSesion.getCedula());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /**
     * Cancela la reserva seleccionada
     */
    public void cancelarReserva() {

        reserva.setEstadoReserva("Cancelado");
        try {
            reservaServicio.actualizarReserva(reserva);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acción procesada", "Procesado con éxito");
            FacesContext.getCurrentInstance().addMessage("reserva-bean", fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("reserva-bean", fm);
        }
    }


    /**
     * @param fecha
     * @return
     */
    public String obtenerFechaComentario(LocalDateTime fecha) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fecha.format(formato);
    }

    /**
     * @param reserva
     * @return
     */
    public String obtenerNombreHotel(Reserva reserva) {

        try {
            return reservaServicio.obtenerHotelReserva(reserva.getCodigo()).get(0).getNombre();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return "";
    }

    /**
     * Setea la reserva seleccionada a la variable global
     *
     * @param reserva seleccionada
     */
    public void seleccionarReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setReservaSeleccionada(Reserva reservaSelec) {
        reservaSeleccionada = reservaSelec;
    }

    /**
     * @param reserva
     * @return
     */
    public String convertirValorTotal(Reserva reserva) {

        Locale locale = new Locale("es", "CO");
        NumberFormat formato = NumberFormat.getCurrencyInstance(locale);
        return formato.format(reserva.getPrecioTotal());
    }
}
