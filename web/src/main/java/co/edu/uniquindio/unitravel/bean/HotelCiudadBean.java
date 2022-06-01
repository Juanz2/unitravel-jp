package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class HotelCiudadBean implements Serializable {

    @Autowired
    private HotelServicio hotelServicio;

    @Value("#{param['ciudad']}")
    private String parametroBusqueda;

    @Getter
    @Setter
    private List<Hotel> listaHoteles;

    @PostConstruct
    public void init (){
        listaHoteles = hotelServicio.obtenerHotelesPorDestino(parametroBusqueda);
    }

    public String irDetalleHotel(String codigoHotel){
        return "detalleHotel?faces-redirect=true&amp;hotelId=" + codigoHotel;
    }
}
