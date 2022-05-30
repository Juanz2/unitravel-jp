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

@Component
@ViewScoped
public class DetalleHotelBean implements Serializable {


    @Autowired
    private HotelServicio hotelServicio;

    @Value("#{param['hotelId']}")
    private String parametroBusqueda;

    @Getter @Setter
    private Hotel hotel;

    @PostConstruct
    public void init(){
        if(parametroBusqueda!=null){
            try {
                hotel = hotelServicio.obtenerHotel(Integer.parseInt(parametroBusqueda));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


}
