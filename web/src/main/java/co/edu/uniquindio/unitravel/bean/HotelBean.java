package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class HotelBean implements Serializable {

    private final HotelServicio hotelServicio;

    @Getter @Setter
    private Hotel hotel;

    public HotelBean(HotelServicio hotelServicio) {
        this.hotelServicio = hotelServicio;
    }

    @PostConstruct
    public void init() {
        hotel = new Hotel();
        hotel.setEstado("A");
    }
    /**
     *
     */
    public void registrarHotel(){
        try {
            hotelServicio.registrarHotel(hotel);
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta\n", "Acción procesada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta\n", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
}
