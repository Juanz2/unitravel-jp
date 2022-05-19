package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
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
public class HotelBean implements Serializable {

    private final HotelServicio hotelServicio;

    @Getter @Setter
    private Hotel hotel;

    @Getter @Setter
    private Hotel hotelSeleccionado;

    @Getter @Setter
    private List<Hotel> listaHoteles;

    @Getter @Setter
    private List<Hotel> hotelesSeleccionados;

    public HotelBean(HotelServicio hotelServicio) {
        this.hotelServicio = hotelServicio;
    }

    @PostConstruct
    public void init() {
        listaHoteles = new ArrayList<>();
        listaHoteles = hotelServicio.obtenerHoteles();
        hotelSeleccionado = new Hotel();
        hotelSeleccionado.setEstado("A");
    }
    /**
     *
     */
    public void registrarHotel(){
        try {
            hotelServicio.registrarHotel(hotelSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Acción procesada"));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-hotel");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            PrimeFaces.current().ajax().update("form:messages", "form:dt-hotel");
        }
    }

    public void openNew(){
        hotel = new Hotel();
    }


}
